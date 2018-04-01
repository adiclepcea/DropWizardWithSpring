package clepcea.gestiune;

import clepcea.gestiune.dao.PriceCategoryDAO;
import clepcea.gestiune.representations.Collaborator;
import clepcea.gestiune.representations.PriceCategory;
import clepcea.gestiune.resources.CollaboratorResource;
import clepcea.gestiune.resources.InvoiceResource;
import clepcea.gestiune.resources.PriceCategoryResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.db.ManagedDataSource;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

/**
 * Hello world!
 *
 */
public class App extends Application<GestiuneConfiguration>
{
    public static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main( String[] args ) throws Exception
    {
        new App().run(args);
    }


    private final HibernateBundle<GestiuneConfiguration> hibernatePriceCategory =
            new HibernateBundle<GestiuneConfiguration>(PriceCategory.class) {
                @Override
                public PooledDataSourceFactory getDataSourceFactory(GestiuneConfiguration configuration) {
                    return configuration.getDatabaseFactory();
                }
            };

    @Override
    public void initialize(Bootstrap<GestiuneConfiguration> config){
        config.addBundle(new MigrationsBundle<GestiuneConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(GestiuneConfiguration configuration){
                return configuration.getDatabaseFactory();
            }
        });
        config.addBundle(hibernatePriceCategory);
    }

    @Override
    public void run(GestiuneConfiguration configuration, Environment environment) throws Exception {
        DataSourceFactory dataSourceFactory = configuration.getDatabaseFactory();
        ManagedDataSource dataSource = dataSourceFactory.build(environment.metrics(), "dataSource");

        ApplicationContext context = new SpringContextBuilder()
                .addParentContextBean("dataSource", dataSource)
                .addParentContextBean("configuration", configuration)
                .addAnnotationConfiguration(GestiuneSpringConfiguration.class)
                .build();

        PriceCategoryDAO priceCategoryDAO = context.getBean(PriceCategoryDAO.class);

        PriceCategoryResource priceCategoryResource = new PriceCategoryResource(priceCategoryDAO);

        environment.jersey().register(new InvoiceResource());
        environment.jersey().register(new CollaboratorResource());
        environment.jersey().register(priceCategoryResource);
    }
}

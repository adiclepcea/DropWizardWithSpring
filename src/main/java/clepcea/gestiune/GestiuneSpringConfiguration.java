package clepcea.gestiune;

import clepcea.gestiune.dao.PriceCategoryDAO;
import org.hibernate.SessionFactory;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.dialect.PostgreSQL9Dialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = PriceCategoryDAO.class)
@ComponentScan(basePackageClasses =  PriceCategoryDAO.class)
public class GestiuneSpringConfiguration{

        @Autowired
        private DataSource _dataSource;

        @Autowired
        private GestiuneConfiguration _configuration;

        @Bean(name="entityManagerFactory")
        public LocalContainerEntityManagerFactoryBean sqlServerEntityManagerFactory() {
            LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
            em.setDataSource(_dataSource);
            em.setPackagesToScan(new String[] { "clepcea.gestiune.representations" });

            JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
            em.setJpaVendorAdapter(vendorAdapter);

            return em;
        }


        @Bean
        public LocalSessionFactoryBean sessionFactory() throws InstantiationException,IllegalAccessException{
            LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
            sessionFactory.setDataSource(_dataSource);
            sessionFactory.setPackagesToScan("clepcea.gestiune.dao");
            sessionFactory.setImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE);
            sessionFactory.setHibernateProperties(hibernateProperties());
            return sessionFactory;
        }


        @Bean(name="transactionManager")
        @Autowired
        public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
            return new HibernateTransactionManager(sessionFactory);
        }

        @Bean
        public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
            return new PersistenceExceptionTranslationPostProcessor();
        }

        public Properties hibernateProperties() {
            return new Properties() {
                {
                    setProperty("hibernate.dialect", PostgreSQL9Dialect.class.getName());
                    setProperty("hibernate.show_sql", "false");
                    setProperty("hibernate.format_sql", "true");
                }
            };
        }
}

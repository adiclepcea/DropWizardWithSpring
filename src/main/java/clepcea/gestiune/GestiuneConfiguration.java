package clepcea.gestiune;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class GestiuneConfiguration extends io.dropwizard.Configuration {
    @NotNull
    @Valid
    DataSourceFactory dataSourceFactory = new DataSourceFactory();

    @JsonProperty("database")
    DataSourceFactory getDatabaseFactory(){
        return dataSourceFactory;
    }

    @JsonProperty("database")
    void setDataSourceFactory(DataSourceFactory dataSourceFactory){
        this.dataSourceFactory = dataSourceFactory;
    }
}

package it.develhope.No.SQL.ORM.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import java.util.Collection;
import java.util.Collections;

    @Configuration
    public class MongoDBConfig extends AbstractMongoClientConfiguration {
        @Override
        protected String getDatabaseName() {
            return "develhope";
        }

        @Override
        public MongoClient mongoClient() {
            ConnectionString connectionString = new ConnectionString("mongodb+srv://nomeutente:pass@cluster0.l9lvvzs.mongodb.net/?retryWrites=true&w=majority");
            MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString).build();
            return MongoClients.create(mongoClientSettings);
        }

        @Override
        protected Collection<String> getMappingBasePackages() {
            return Collections.singleton("co.develhope");
        }

        @Override
        protected boolean autoIndexCreation() {
            return true;
        }
}

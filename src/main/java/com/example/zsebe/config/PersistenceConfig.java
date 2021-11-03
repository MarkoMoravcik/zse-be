/*
 * Copyright (c) 2020 ITZBund. All rights reserved.
 */
package com.example.zsebe.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Jaroslav Sebes
 */
@EnableTransactionManagement
@EnableJpaRepositories("com.example.zsebe.db.repository")
@EntityScan("com.example.zsebe.db.entity")
@Configuration
public class PersistenceConfig {

}

package org.nettoall.orca.mvc.service;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @ConfigurationProperties를 사용하기 위해 bootApplication 에
 * @EnableConfigurationProperties 정의 해야 함
 */
@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "upload-dir";

    public String getLocations() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

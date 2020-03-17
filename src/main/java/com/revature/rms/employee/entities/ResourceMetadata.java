package com.revature.rms.employee.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class ResourceMetadata {

    private Integer resourceCreatorId;
    private String resourceCreationDateTime;
    private Integer lastModifierId;
    private String lastModifiedDateTime;
    private Integer resourceOwnerId;
    private boolean isActive;

    public ResourceMetadata() {
        super();
    }

    public ResourceMetadata(Integer creatorId, LocalDateTime creationDT, Integer modifierId, LocalDateTime modifiedDT, Integer ownerId) {
        this.resourceCreatorId = creatorId;
        this.resourceCreationDateTime = creationDT.toString();
        this.lastModifierId = modifierId;
        this.lastModifiedDateTime = modifiedDT.toString();
        this.resourceOwnerId = ownerId;
        this.isActive = true;
    }

    public ResourceMetadata(Integer creatorId, LocalDateTime creationDT, Integer modifierId, LocalDateTime modifiedDT, Integer ownerId, boolean active) {
        this.resourceCreatorId = creatorId;
        this.resourceCreationDateTime = creationDT.toString();
        this.lastModifierId = modifierId;
        this.lastModifiedDateTime = modifiedDT.toString();
        this.resourceOwnerId = ownerId;
        this.isActive = active;
    }

    public Integer getResourceCreatorId() {
        return resourceCreatorId;
    }

    public void setResourceCreatorId(Integer resourceCreatorId) {
        if (resourceCreatorId == null || resourceCreatorId <= 0) return;
        this.resourceCreatorId = resourceCreatorId;
    }

    public String getResourceCreationDateTime() {
        return resourceCreationDateTime;
    }

    public void setResourceCreationDateTime(LocalDateTime resourceCreationDateTime) {
        if (resourceCreationDateTime == null) return;
        this.resourceCreationDateTime = resourceCreationDateTime.toString();
    }

    public Integer getLastModifierId() {
        return lastModifierId;
    }

    public void setLastModifierId(Integer lastModifierId) {
        this.lastModifierId = lastModifierId;
    }

    public String getLastModifiedDateTime() {
        return lastModifiedDateTime;
    }

    public void setLastModifiedDateTime(LocalDateTime lastModifiedDateTime) {
        this.lastModifiedDateTime = lastModifiedDateTime.toString();
    }

    public Integer getResourceOwnerId() {
        return resourceOwnerId;
    }

    public void setResourceOwnerId(Integer resourceOwnerId) {
        this.resourceOwnerId = resourceOwnerId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceMetadata that = (ResourceMetadata) o;
        return isActive == that.isActive &&
                resourceCreatorId.equals(that.resourceCreatorId) &&
                resourceCreationDateTime.equals(that.resourceCreationDateTime) &&
                lastModifierId.equals(that.lastModifierId) &&
                lastModifiedDateTime.equals(that.lastModifiedDateTime) &&
                resourceOwnerId.equals(that.resourceOwnerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resourceCreatorId, resourceCreationDateTime, lastModifierId, lastModifiedDateTime, resourceOwnerId, isActive);
    }

    @Override
    public String toString() {
        return "ResourceMetadata{" +
                "resourceCreatorId=" + resourceCreatorId +
                ", resourceCreationDateTime='" + resourceCreationDateTime + '\'' +
                ", lastModifierId=" + lastModifierId +
                ", lastModifiedDateTime='" + lastModifiedDateTime + '\'' +
                ", resourceOwnerId=" + resourceOwnerId +
                ", isActive=" + isActive +
                '}';
    }

}

package com.juanjoLibrero.trelloApp.persistence.audit;

import com.juanjoLibrero.trelloApp.persistence.entity.TaskEntity;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;
import org.springframework.util.SerializationUtils;

public class AuditTaskListener {
    private TaskEntity currentValue;

    @PostLoad
    public void postLoad(TaskEntity entity) {
        this.currentValue = SerializationUtils.clone(entity);
    }

    @PostPersist
    @PostUpdate
    public void onPostPersist(TaskEntity entity) {
        System.out.println("POST PERSIST OR UPDATE");
        System.out.println("OLD VALUE: " + this.currentValue);
        System.out.println("NEW VALUE: " + entity.toString());
    }

    @PreRemove
    public void onPreDelete(TaskEntity entity) {
        System.out.println(entity.toString());
    }
}

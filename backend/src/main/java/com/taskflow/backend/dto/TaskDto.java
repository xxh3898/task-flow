package com.taskflow.backend.dto;

import com.taskflow.backend.entity.Enums;
import com.taskflow.backend.entity.Task;
import lombok.*;

import java.time.LocalDateTime;

public class TaskDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Create {
        private String title;
        private String description;

        public Task toEntity() {
            return Task.builder()
                    .title(title)
                    .description(description)
                    .status(Enums.TaskStatus.TODO)
                    .build();
        }
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Update {
        private String title;
        private String description;
        private Enums.TaskStatus status;
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Response {
        private Long id;
        private String title;
        private String description;
        private LocalDateTime createdAt;
        private String status;

        public static Response of(Task task) {
            return Response.builder()
                    .id(task.getId())
                    .title(task.getTitle())
                    .description(task.getDescription())
                    .createdAt(task.getCreatedAt())
                    .status(task.getStatus().toString())
                    .build();
        }
    }
}

package me.yoryor.plugin.entity;

import io.vertx.core.json.JsonObject;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class Issue {
    // 任务标识
    private String id;
    // 任务类型
    private String type;
    // 任务描述
    private String summary;
    // 任务详情
    private String description;
    // 任务优先级
    private String priority;
    // 被分配任务的人
    private String assignee;
    // 创建者
    private String creator;
    // 关注者
    private String watcher;
    // 用户名
    private String user;
    // 任务详情地址
    private String url;
    // 任务状态
    private String status;
    // 影响版本
    private List<String> versions;
    // 报告人
    private String reporter;
    // 修复版本
    private List<String> fixVersions;
    // 创建日期
    private LocalDateTime created;

    public static Issue fromJson(JsonObject jsonObject) {
        return Issue.builder()
                .id(jsonObject.getString("id", ""))
                .type(jsonObject.getString("type", ""))
                .summary(jsonObject.getString("summary", ""))
                .description(jsonObject.getString("description", ""))
                .priority(jsonObject.getString("priority", ""))
                .assignee(jsonObject.getString("assignee", ""))
                .creator(jsonObject.getString("creator", ""))
                .watcher(jsonObject.getString("watcher", ""))
                .user(jsonObject.getString("user", ""))
                .url(jsonObject.getString("url", ""))
                .status(jsonObject.getString("status", ""))
                .versions(jsonObject.getJsonArray("versions").getList())
                .reporter(jsonObject.getString("reporter", ""))
                .fixVersions(jsonObject.getJsonArray("fixVersions").getList())
                .created(LocalDateTime.parse(jsonObject.getString("created"), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSx")))
                .build();
    }
}

package com.example.demo.dto;

import com.example.demo.model.TodoEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoDTO {
    private String id;
    private String title;
    private boolean done;

    /*
     * final TodoEntity entity에서 final 의미
     * 이 생성자는 외부에서 전달받은 entity를 그대로 읽기만 한다.
     * 메소드 내부에서 entity.setId("1234") 사용 못함.
     */
    public TodoDTO(final TodoEntity entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.done = entity.isDone();
    }

    public static TodoEntity toEntity(final TodoDTO todoDTO) {
        return TodoEntity.builder()
                .id(todoDTO.getId())
                .title(todoDTO.getTitle())
                .done(todoDTO.isDone())
                .build();
    }
}

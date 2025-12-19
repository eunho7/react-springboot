package com.example.demo.service;

import com.example.demo.model.TodoEntity;
import com.example.demo.persistence.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public String testService() {
        // TodoEntity 생성
        TodoEntity entity = TodoEntity.builder().title("My first todo item.").build();
        // TodoEntity 저장
        todoRepository.save(entity);
        // TodoEntity 검색
        TodoEntity savedEntity = todoRepository.findById(entity.getId()).get();
        return savedEntity.getTitle();
    }

    // create todo
    public List<TodoEntity> create(final TodoEntity entity) {
        // Validations
        validate(entity);

        todoRepository.save(entity);

        log.info("Entity Id : {} is saved", entity.getId());

        return todoRepository.findByUserId(entity.getUserId());
    }

    // Read todo
    public List<TodoEntity> read(final String userId) {
        return todoRepository.findByUserId(userId);
    }

    // 리팩토링한 메소드
    private void validate(final TodoEntity entity) {
        if (entity == null) {
            log.warn("Entity cannot be null.");
            throw new RuntimeException("Entity cannot be null.");
        }

        if (entity.getUserId() == null) {
            log.warn("Unknown user");
            throw new RuntimeException("Unknown user");
        }
    }
}

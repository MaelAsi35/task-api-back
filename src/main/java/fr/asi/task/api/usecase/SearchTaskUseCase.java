package fr.asi.task.api.usecase;

import fr.asi.task.api.dto.TaskDto;
import fr.asi.task.api.dto.TaskSearchDto;
import fr.asi.task.api.mapper.TaskMapper;
import fr.asi.task.api.model.Task;
import fr.asi.task.api.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class SearchTaskUseCase {
    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    private TaskRepository taskRepository;

    /**
     * Search on tasks
     *
     * @param pageable      page
     * @param searchTaskDto search dto
     * @return tasks found regarding the filters
     */
    public Page<TaskDto> execute(Pageable pageable, TaskSearchDto searchTaskDto) {

        Specification<Task> specification = Specification.where(null);

        if (searchTaskDto.getComplete() != null) {
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("complete"), searchTaskDto.getComplete()));
        }

        if (searchTaskDto.getLabel() != null) {
            specification = specification.and((root, query, criteriaBuilder) ->
                    criteriaBuilder.equal(root.get("label"), searchTaskDto.getLabel()));
        }

        Page<Task> all = taskRepository.findAll(specification, pageable);

        return all.map(taskMapper::toDto);
    }
}
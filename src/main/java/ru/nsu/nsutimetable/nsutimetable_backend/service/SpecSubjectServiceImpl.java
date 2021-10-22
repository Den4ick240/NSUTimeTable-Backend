package ru.nsu.nsutimetable.nsutimetable_backend.service;

import org.springframework.stereotype.Service;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.GroupInfo;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.UserInfo;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.spec.Subject;

import java.util.List;

@Service
public class SpecSubjectServiceImpl implements SpecSubjectService {
    private final SpecCoursesService specCoursesService;

    public SpecSubjectServiceImpl(SpecCoursesService specCoursesService) {
        this.specCoursesService = specCoursesService;
    }

    @Override
    public List<Subject> findAllForGroupInfo(GroupInfo groupInfo) {
        return specCoursesService.getSpecCourses()
                .getFaculties().stream().filter(faculty -> faculty.getName().equals(groupInfo.getFaculty())).findFirst() .get()
                .getDegrees().stream().filter(degree -> degree.getName().equals(groupInfo.getDegree())).findFirst().get()
                .getCourses().stream().filter(course -> course.getNum().equals(groupInfo.getCourseNum())).findFirst().get()
                .getSubjects();
    }
}

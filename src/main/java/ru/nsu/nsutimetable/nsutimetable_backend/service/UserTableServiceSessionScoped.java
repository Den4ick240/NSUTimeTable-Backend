package ru.nsu.nsutimetable.nsutimetable_backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.UserTable;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.api_forms.AddSubjectFrom;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.api_forms.RemoveSubjectForm;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.api_forms.UpdateSubjectForm;
import ru.nsu.nsutimetable.nsutimetable_backend.domain.entities.faculty_schedules.Table;
import ru.nsu.nsutimetable.nsutimetable_backend.exception.TableException;

@Service
@SessionScope
public class UserTableServiceSessionScoped implements UserTableService {
    private UserTable userSchedule = null;

    @Override
    public UserTable getUserTable() {
        return userSchedule;
    }

    @Override
    public void setUserTable(UserTable userSchedule) {
        this.userSchedule = userSchedule;
    }

    @Override
    public void addSubject(AddSubjectFrom addSubjectFrom) {
        getTable(addSubjectFrom.getDayNum()).getSubjects().add(addSubjectFrom.getSubject());

    }

    @Override
    public void removeSubject(RemoveSubjectForm removeSubjectForm) {
        getTable(removeSubjectForm.getDayNum())
                .getSubjects()
                .removeIf(removeSubjectForm::subjectMatches);
    }

    @Override
    public void updateSubject(UpdateSubjectForm updateSubjectForm) throws TableException {
        RemoveSubjectForm oldSubjectForm = updateSubjectForm.getOldSubject();
        var oldDayNum = oldSubjectForm.getDayNum();
        var newDayNum = updateSubjectForm.getDayNum();
        var subject = getTable(oldDayNum)
                .getSubjects()
                .stream().filter(oldSubjectForm::subjectMatches)
                .findFirst()
                .orElseThrow(() -> new TableException("No subject present to update"));

        if (newDayNum != null && !newDayNum.equals(oldDayNum)) {
            getTable(oldDayNum).getSubjects().remove(subject);
            getTable(newDayNum).getSubjects().add(subject);
        }

        var newLessonNum = updateSubjectForm.getLessonNum();
        if (newLessonNum != null) subject.setLessonNum(newLessonNum);
        var newRoom = updateSubjectForm.getRoom();
        if (newRoom != null) subject.setRoom(newRoom);
    }

    private Table getTable(int dayNum) {
        return userSchedule.getTable()
                .stream()
                .filter(table -> table.getDayNum().equals(dayNum))
                .findFirst()
                .orElseThrow(
                        () -> new RuntimeException("Trying to add subject to incorrect dayNum")
                );
    }
}

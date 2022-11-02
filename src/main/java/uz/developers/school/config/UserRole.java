package uz.developers.school.config;

import com.google.common.collect.Sets;

import java.util.Set;

import static uz.developers.school.config.UserPermission.*;
import static uz.developers.school.config.UserPermission.TIMETABLE_READ_ONE;
//todo task structure sini qushish kerak
public enum UserRole {

    STUDENT(Sets.newHashSet(GROUP_READ_ONE,
            MARK_READ_ALL,MARK_READ_ONE,
            SCHOOL_READ_ONE,
            STUDENT_READ_ALL,STUDENT_READ_ONE,
            SUBJECT_READ_ALL,SUBJECT_READ_ONE,
            TIMETABLE_READ_ALL)),

    TEACHER(Sets.newHashSet(GROUP_READ_ALL,GROUP_READ_ONE,
            MARK_READ_ALL,MARK_READ_ONE,MARK_ADD,MARK_EDIT,
            SCHOOL_READ_ONE,
            STUDENT_READ_ALL,STUDENT_READ_ONE,
            SUBJECT_READ_ALL,SUBJECT_READ_ONE,
            TIMETABLE_READ_ALL,TIMETABLE_READ_ONE)),

    DIRECTOR(Sets.newHashSet(GROUP_READ_ALL,GROUP_READ_ONE,GROUP_ADD,GROUP_EDIT,GROUP_DELETE,
            MARK_READ_ALL,MARK_READ_ONE,MARK_ADD,MARK_EDIT,MARK_DELETE,
            SCHOOL_READ_ALL,SCHOOL_READ_ONE,
            STUDENT_READ_ALL,STUDENT_READ_ONE,STUDENT_ADD,STUDENT_EDIT,STUDENT_DELETE,
            SUBJECT_READ_ALL,SUBJECT_READ_ONE,
            TEACHER_READ_ALL,TEACHER_READ_ONE,TEACHER_ADD,TEACHER_EDIT,TEACHER_DELETE,
            TIMETABLE_READ_ALL,TIMETABLE_READ_ONE,TIMETABLE_ADD,TIMETABLE_EDIT,TIMETABLE_DELETE));

    //todo MINISTER ROLI ni qushish kerak
    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }
}

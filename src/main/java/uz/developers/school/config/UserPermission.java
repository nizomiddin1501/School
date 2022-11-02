package uz.developers.school.config;

public enum UserPermission {


    GROUP_READ_ALL("group:readAll"),
    GROUP_READ_ONE("group:readOne"),
    GROUP_ADD("group:add"),
    GROUP_EDIT("group:edit"),
    GROUP_DELETE("group:delete"),

    MARK_READ_ALL("mark:readAll"),
    MARK_READ_ONE("mark:readOne"),
    MARK_ADD("mark:add"),
    MARK_EDIT("mark:edit"),
    MARK_DELETE("mark:delete"),

    SCHOOL_READ_ALL("school:readAll"),
    SCHOOL_READ_ONE("school:readOne"),
    SCHOOL_ADD("school:add"),
    SCHOOL_EDIT("school:edit"),
    SCHOOL_DELETE("school:delete"),

    STUDENT_READ_ALL("student:readAll"),
    STUDENT_READ_ONE("student:readOne"),
    STUDENT_ADD("student:add"),
    STUDENT_EDIT("student:edit"),
    STUDENT_DELETE("student:delete"),

    SUBJECT_READ_ALL("subject:readAll"),
    SUBJECT_READ_ONE("subject:readOne"),
    SUBJECT_ADD("subject:add"),
    SUBJECT_EDIT("subject:edit"),
    SUBJECT_DELETE("subject:delete"),

    TEACHER_READ_ALL("teacher:readAll"),
    TEACHER_READ_ONE("teacher:readOne"),
    TEACHER_ADD("teacher:add"),
    TEACHER_EDIT("teacher:edit"),
    TEACHER_DELETE("teacher:delete"),

    TIMETABLE_READ_ALL("timeTable:readAll"),
    TIMETABLE_READ_ONE("timeTable:readOne"),
    TIMETABLE_ADD("timeTable:add"),
    TIMETABLE_EDIT("timeTable:edit"),
    TIMETABLE_DELETE("timeTable :delete");


    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}

package com.bgm.workoutzback.model;

import javax.persistence.*;

@Entity
public class ProgramWeek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int weekNum;
    @OneToOne
    private Program program;

    public ProgramWeek() { }

    public ProgramWeek(int weekNum, Program program) {
        this.weekNum = weekNum;
        this.program = program;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getWeekNum() {
        return weekNum;
    }

    public void setWeekNum(int weekNum) {
        this.weekNum = weekNum;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

}

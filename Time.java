package delfinen;

public class Time {
    private int time;
    private Member member;

    public Time(int time, Member member) {
        this.time = time;
        this.member = member;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}

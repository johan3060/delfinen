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

    public Member getMember() {
        return member;
    }

}

public class MonthDays {

    private int days;
    static int[] dayList = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    MonthDays(int month, int year) {
        if (month != 2) {
            this.days = dayList[month + 1];
        } else if (year % 100 == 0) {

            if (year % 400 == 0) {
                this.days = 29;
            } else {
                this.days = 28;
            }

        } else {

            if (year % 4 == 0) {
                this.days = 29;
            }

            else {
                this.days = 28;
            }

        }
    }

    public int numberOfDays() {
        return days;
    }

}

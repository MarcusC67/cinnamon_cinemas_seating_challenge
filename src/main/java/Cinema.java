public class Cinema {

    private String str;
    private int seatsAvailable;
    String returnStr;

    private int j = 0;
    int newRow = 0;
    char rowLetter = 'A';
    String ROWS = "ABC";

    StringBuilder seatsBooked = new StringBuilder();

    // constructor
    public Cinema() {
        // max seats in cinema = 15 (3 rows A,B,C - each row with 5 seats)
        this.seatsAvailable = 15;
    }

    public String allocateSeats(int seatsRequested) {

        if (seatsAvailable == 0) {
            return "Sorry, no seats available!";
        } else {

            try {
                if (seatsRequested >= 1 && seatsRequested <= 3) {
                    // loop through requested seats 1-3
                    for (int k = 0; k < seatsRequested; k++) {
                        j++;
                        str = String.valueOf(seatsBooked.append(allocateOneSeat(newRow, j)).append(" "));
                        seatsAvailable--;
                    }
                } else {
                    return "Sorry, number of seats requested must be between 1 and 3!";
                }
            } catch (Exception e) {
                System.out.println("Something went wrong.");
            }
        }
        str = str.substring(0, str.length() - 1); // strip out last space
        return str; // return string of all booked seats
    }

    private String allocateOneSeat(int row, int seat) {

        // if last seat in row, update row to next row eg: A to B or B to C
        if (seat == 5) {
            returnStr = rowLetter + String.valueOf(seat);

            // if this is not the last seat available, then continue to next row
            if (seatsAvailable != 1)
                newRow = row + 1;
                rowLetter = ROWS.charAt(newRow);
                seat = 1;
                j = 0;

        } else {
            // set return string to allocated row and seat eg: A1
            returnStr = rowLetter + String.valueOf(seat);
            seat ++;
        }
        return returnStr; // return allocated row and seat eg: A1
    }

}

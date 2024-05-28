import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ActivityTest {
    private String activityName = "CallofDuty";
    private Date setDate = new Date(124, 3, 21, 9, 0);
    private String activityType = "Game";
    private String activityVenue = "PlayStation";
    private int maxplayernum = 100;



    @Test
    void testDefaultConstructor(){
        Activity newActivity = new Activity();
        assertEquals("TBD", newActivity.getActivityName());
        assertEquals("TBD", newActivity.getActivityVenue());
        assertEquals(0, newActivity.getMaxPlayerNumber());
        Date currentTime = new Date();
        Date activityTime = newActivity.getActivityTime();
        long currentTimeMillis = currentTime.getTime();
        long activityTimeMillis = activityTime.getTime();
        long allowedDifference = 1000;
        assertTrue(Math.abs(currentTimeMillis - activityTimeMillis) <= allowedDifference);

    }
    // Mender: Jiarui Yang , Time: 4.19 .
    // To check whether the default value of each parameter matches the given value.

    @Test
    void testMainConstructor(){
        Activity newActivity1 = new Activity(activityName, setDate, activityType, activityVenue, maxplayernum);
        assertEquals("CallofDuty", newActivity1.getActivityName());
        assertEquals(setDate, newActivity1.getActivityTime());
        assertEquals("PlayStation", newActivity1.getActivityVenue());
        assertEquals(100, newActivity1.getMaxPlayerNumber());
        assertTrue(newActivity1.getMemberList().isEmpty());

    }
    // Mender: Jiarui Yang , Time: 4.19 .
    // We assign a value to each variable through newActivity, and then use assertEquals and assertTrue to check the main constructior


    @Test
    void getActivityTime() {
        Date time1 = new Date();
        Activity newActivity2 = new Activity();
        assertTrue(newActivity2.getActivityTime() instanceof Date);

    }

    // Mender: Jiarui Yang , Time: 4.19 .
    // To check whether the getActivityTime method can return a 'Date' type result.

    @Test
    void getActivityName() {
        Activity newActivity3 = new Activity(activityName, setDate, activityType, activityVenue, maxplayernum);
        assertTrue(newActivity3.getActivityName() instanceof String);
    }

    // Mender: Jiarui Yang , Time: 4.19 .
    // To check whether the getActivityName method can return a 'String' type result.

    @Test
    void getActivityVenue() {
        Activity newActivity4 = new Activity(activityName, setDate, activityType, activityVenue, maxplayernum);
        assertTrue(newActivity4.getActivityVenue() instanceof String);
    }

    // Mender: Jiarui Yang , Time: 4.19 .
    // To check whether the getActivityVenue method can return a 'String' type result.

    @Test
    void getMaxPlayerNumber() {
        Activity newActivity5 = new Activity(activityName, setDate, activityType, activityVenue, maxplayernum);
        int maxPlayerNumber = newActivity5.getMaxPlayerNumber();
        Integer maxPlayerNumberInteger = Integer.valueOf(maxPlayerNumber);
        assertEquals(100, maxPlayerNumberInteger);
        assertTrue(maxPlayerNumberInteger instanceof Integer);
    }
    // Mender: Jiarui Yang , Time: 4.19 .
    // To check whether the getMaxPlayerNumber method can return a 'Integer' type result. Meantime, we check the value of the result.


    @Test
    void getMemberList() {
        Date setDate = new Date(124, 3, 21, 9, 0);
        Activity activity = new Activity("CallofDuty", setDate, "Game", "PlayStation", 100);
        assertTrue(activity.getMemberList() instanceof ArrayList);
        Activity a = new Activity();
        assertNotNull(a.getMemberList());
        assertTrue(a.getMemberList() instanceof ArrayList);
    }

    //Mender: Tingshuai Ding， Time：4.23.
    //Ensures that the getMemberList() method behaves correctly in both cases: when an Activity object is created with parameters and when it's created using the default constructor.

    @Test
    void setActivityTime() {
        Date expectedTime = new Date(124, 3, 21, 9, 0);
        Activity activity = new Activity();
        activity.setActivityTime(expectedTime);

        Date actualTime = activity.getActivityTime();

        assertEquals(expectedTime, actualTime);
    }

    //Mender: Tingshuai Ding， Time：4.23.
    //Verifies that the setActivityTime() method correctly sets the activity time to the specified value


    @Test
    void setActivityName() {
        Activity activity = new Activity();
        String newName = "New Activity Name";
        activity.setActivityName(newName);
        assertEquals(newName, activity.getActivityName());
    }

    //Mender: Tingshuai Ding， Time：4.23.
    //Ensures that the setActivityName() method correctly sets the activity name of the Activity object to the specified value and that the getActivityName() method retrieves the correct activity name.


    @Test
    void setActivityVenue() {
        Activity activity = new Activity();
        assertTrue(activity.isVenueValid());
        activity.setActivityVenue("New Venue");
        assertEquals("New Venue", activity.getActivityVenue());
    }
    //Mender: Tingshuai Ding， Time：4.23.
    //Confirms that the setActivityVenue() method correctly updates the venue of the Activity object, and the getActivityVenue() method retrieves the updated venue as expected. Additionally, it ensures that the isVenueValid() method functions appropriately by initially considering the venue as valid.

    @Test
    void setMaxPlayerNumber() {
        Activity activity = new Activity();
        int validMaxPlayerNumber = 10;
        activity.setMaxPlayerNumber(validMaxPlayerNumber);
        assertEquals(validMaxPlayerNumber, activity.getMaxPlayerNumber());
    }
    //Mender: Tingshuai Ding， Time：4.23.
    //Ensures that the setMaxPlayerNumber() method correctly updates the maximum player number of the Activity object to the specified value, and the getMaxPlayerNumber() method retrieves the updated maximum player number as expected.

    @Test
    void addMember() {
        Activity activity = new Activity();
        User user = new User("HaotaoWang", 1, "Admin");
        activity.addMember(user);
        assertTrue(activity.getMemberList().contains(user));
    }
    //Mender: Tingshuai Ding， Time：4.23.
    //Ensures that the addMember() method correctly adds a user to the member list of the Activity object, and subsequently confirms that the user is indeed present in the member list.

    @Test
    void removeMember() {
        Activity activity = new Activity();
        User user = new User("HaotaoWang", 1, "Admin");
        activity.addMember(user);
        assertTrue(activity.getMemberList().contains(user));
        activity.removeMember(user);
        assertFalse(activity.getMemberList().contains(user));
    }
    //Mender: Tingshuai Ding， Time：4.23.
    //Ensures the removeMember() method correctly removes a user from the member list of the Activity object, and subsequently confirms that the user is no longer present in the member list.

    @Test
    void isVenueValid() {
        // Test 1: Venue should be valid when it has not been set
        // Assuming default constructor sets venue to null
        Activity activityWithoutVenue = new Activity();
        assertTrue(activityWithoutVenue.isVenueValid());

        // Test 2: Venue should not be alid when it has been set
        // Correctly use the constructor with the right parameters
        Activity activityWithVenue = new Activity("CallofDuty", new Date(), "Local Gym", "Gym Arena", 12);
        assertFalse(activityWithVenue.isVenueValid());

    }

    //Mender: Qize CHEN, Time: 4.20
    //This test verifies the correctness of the isVenueValid() method by
    //checking its behavior with various scenarios, including the case
    //where the activityVenue has not been set and thus can be set.

    @Test
    void isMaxNumValid() {
        // Test 1: Max Player Number should be valid when it has not been set (default is 0)
        Activity activityWithoutMaxNum = new Activity();
        assertTrue(activityWithoutMaxNum.isMaxNumValid());

        // Test 2: Max Player Number should not be valid when it has been set (any number other than 0)
        Activity activityWithMaxNum = new Activity("Basketball", new Date(), "Local Gym", "Court 1", 100);
        assertFalse(activityWithMaxNum.isMaxNumValid());

    }
    //Mender: Qize CHEN, Time: 4.20
    //This test verifies the correctness of the isMaxNumValid() method by
    //checking its behavior with various scenarios, including the case
    //where the maxPlayerNumber has not been set and thus can be set.

    @Test
    void isMemberNumValid() {
        // Test scenario where the member list is empty
        Activity activityEmpty = new Activity();  // Assuming default constructor initializes an empty list
        assertTrue(activityEmpty.isMemberNumValid());

        // Test scenario where the member list is not empty
        Activity activityNotEmpty = new Activity();
        User user = new User("John Doe", 1, "Member");  // Assuming a suitable User constructor
        activityNotEmpty.addMember(user);  // Add a user to make the list not empty
        assertFalse(activityNotEmpty.isMemberNumValid());

    }
    //Mender: Qize CHEN, Time: 4.20
    //This test verifies the correctness of the isMemberNumValid() method by
    //checking its behavior with various scenarios, including the case
    //where the memberList is empty and thus new members can be added.

    @Test
    void isTimeValid() {
        // Test scenario where activityTime is expected to be null
        Activity activityWithoutTimeSet = new Activity();
        assertTrue(activityWithoutTimeSet.isTimeValid(), "isTimeValid should return true when activityTime has not been set");

        // Setting the activityTime to check the change in state
        Activity activityWithTimeSet = new Activity();
        activityWithTimeSet.setActivityTime(setDate);
        assertFalse(activityWithTimeSet.isTimeValid(), "isTimeValid should return false when activityTime is already set");
    }
    //Mender: Qize CHEN, Time: 4.23
    //This test verifies the correctness of the isTimeValid() method by
    //checking its behavior with various scenarios, including the case
    // where the activityTime has not been set and thus can be set.

    @Test
    void testToString() {
        Date now = new Date();

        // Creating an Activity instance
        Activity activity = new Activity("Evening Yoga", now, "Fitness", "Local Gym", 15);

        // Check if the toString method returns the expected string
        String expected = "Activity Information:\n" +
                "Name: Evening Yoga\n" +
                "Time: " + now.toString() + "\n" + // Using Date's toString method directly
                "Venue: Local Gym\n" +
                "Booked Member Number: 0\n"; // Assuming the initial number of booked members is 0
        String actual = activity.toString();

        assertEquals(expected, actual, "The toString output is not as expected.");

    }

    //Mender: Qize CHEN, Time: 4.23
    //This test verifies the correctness of the toString() method by
    //checking if it returns a string representation of the Activity object,
    //including the activity's information and the number of booked members.
}
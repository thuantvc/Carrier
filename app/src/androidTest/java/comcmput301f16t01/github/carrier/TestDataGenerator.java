package comcmput301f16t01.github.carrier;

import java.lang.reflect.Array;
import java.util.ArrayList;

import comcmput301f16t01.github.carrier.Requests.Request;
import comcmput301f16t01.github.carrier.Requests.RequestController;
import comcmput301f16t01.github.carrier.Requests.RequestList;
import comcmput301f16t01.github.carrier.Users.User;
import comcmput301f16t01.github.carrier.Users.UserController;

/**
 * You may generate test data to have while using the app using the top test. To remove the data
 * you can use the second test.
 */

public class TestDataGenerator extends ApplicationTest {
    private User userOne = new User( "BriskBen95", "Ben_H@gmail.com", "(526)-989-2501", "Clean sky blue coupe with a sunroof.");
    private User userTwo = new User( "JLynch", "jim.lynch75@yahoo.ca", "(342)-861-7675", "Pale gold convertible with a lowered body and tinted windows." );
    private User userThree = new User( "C_Bradley", "celi_b27@gmail.com", "(213)-700-9383", "Green sedan, license plate: 'TONI JO'" );
    private User userFour = new User( "FPerkins", "perkins78@hotmail.com", "(584)-655-5126", "Yellow crossover with a silver artsy decal. Hula dancer bobble head on dashboard." );
    private User userFive = new User( "Lillie.E", "evans_lillie@yahoo.co.jp", "(916)-343-4874", "Black 2015 Fiat 500C convertible, just washed" );
    private User userSix = new User( "Eli_G", "e.gilbert72@hotmail.ca", "(822)-277-6434", "Red Porsche Cayenne GTS" );
    private User userSeven = new User( "J.Welch", "JWelch@EdmontonHousingLtd.ca", "(207)-746-8954", "The little blue Volkswagen bus" );
    private User userEight = new User( "Wade", "whopkins51@gmail.com", "(824)-535-5663", "White and black 1988 Porsche 911 g50" );
    private User userNine = new User( "Riveras", "a_rivera@hotmail.com", "(560)-210-4866", "Brownish Ford F-150" );
    private User userTen = new User( "WillardD", "davis_w@gmail.com", "(867)-437-3270", "1971 burnt orange Buick Skylark" );
    private User userEleven = new User( "SWallace", "swallace15@yahoo.ca", "(309)-537-6899", "White Daihatsu truck" );
    private User userTwelve = new User( "Jamie_W", "watkins87@gmail.com", "(362)-338-6168", "2012 Bugatti Veyron Grand Sport" );
    private User[] userList = { userOne, userTwo, userThree, userFour, userFive, userSix, userSeven,
            userEight, userNine, userTen, userEleven, userTwelve };

    /* Edmonton Locations */
    CarrierLocation epcorTower = new CarrierLocation( 53.5475, -113.4928 );
    CarrierLocation universityOfAlberta = new CarrierLocation( 53.5232, -113.5263 );
    CarrierLocation centuryPark = new CarrierLocation( 53.4577, -113.5164 );
    CarrierLocation westEdmontonMall = new CarrierLocation( 53.5225, -113.6242 );
    CarrierLocation rogerPlace = new CarrierLocation( 53.5469, -113.6242 );
    CarrierLocation collegePlaza = new CarrierLocation( 53.5187, -113.5202 );
    CarrierLocation southGate = new CarrierLocation( 53.4855, -113.5140 );
    CarrierLocation kingswayMall = new CarrierLocation( 53.5627, -113.5055 );
    CarrierLocation thePearl = new CarrierLocation( 53.5406, -113.5287 );
    CarrierLocation japaneseRestaurant = new CarrierLocation( 53.5413, -113.5254 );
    CarrierLocation macewan = new CarrierLocation( 53.5471, -113.5066 );
    CarrierLocation churchillSquare = new CarrierLocation( 53.5442, -113.4898 );

    Request requestOne = new Request( userOne, epcorTower, thePearl, "I want to go home from from working downtown." );

    /**
     * Generates data for use with a live demo.
     */
    public void testPostData() {
        // create profile for all users.
        for ( User user : userList ) {
            UserController.createNewUser( user.getUsername(), user.getEmail(), user.getPhone(), user.getVehicleDescription() );
            UserController.logOutUser();
        }

        RequestController.addRequest( requestOne );

        RequestList requestList = RequestController.fetchAllRequestsWhereRider( userOne );
        int pass = 0;
        while (requestList.size() == 0) {
            requestList = RequestController.fetchAllRequestsWhereRider( userOne );
            pass++;
            if (pass > 5) { fail(); }
        }

    }

    /**
     * Removes the data generated by testPostData.
     */
    public void testRemoveData() {
        // remove generated profiles
        for ( User user : userList ) {
            UserController.deleteUser( user.getUsername() );
        }

        RequestController.clearAllRiderRequests( userOne );
    }
}

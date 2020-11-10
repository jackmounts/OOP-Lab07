/**
 * 
 */
package it.unibo.oop.lab.enum2;

import java.util.HashSet;
import java.util.Set;

//import it.unibo.oop.lab.enum1.Sport; 
/**
 * Warning:
 * should not import {@link import it.unibo.oop.lab.enum1.Sport} as it 
 * conflicts with {@link import it.unibo.oop.lab.enum2.Sport} 
 */
import it.unibo.oop.lab.enum2.Sport;
import it.unibo.oop.lab.enum1.SportSocialNetworkUserImpl;
import it.unibo.oop.lab.socialnetwork.SocialNetworkUserImpl;
import it.unibo.oop.lab.socialnetwork.User;


/**
 * 
 * Represents a social network user along with the sports he/she likes to do or
 * to follow.
 * 
 * It is the same class as previous exercises but with new methods to be
 * implemented
 * 
 * 
 * 1) Reuse the same code you have already written in the previous
 * SportSocialNetworkUserImpl as far as methods implemented before are concerned
 * 
 * 2) complete the implementation of the new methods as explained below
 * 
 * @param <U>
 *            specific {@link User} type
 */

@SuppressWarnings("unused")
public class Sport2SocialNetworkUserImpl<U extends User> extends SocialNetworkUserImpl<U> {

    /*
     * TODO
     * 
     * add a field to keep track of the set of sports followed/done by a user
     */
	private Set<Sport> followedSports;
	

    /**
     * Builds a new {@link SportSocialNetworkUserImpl}.
     * 
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public Sport2SocialNetworkUserImpl(final String name, final String surname, final String user) {
        this(name, surname, user, -1);
        this.followedSports = new HashSet<Sport>();
    }

    /**
     * Builds a new {@link SportSocialNetworkUserImpl}.
     * 
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */
    public Sport2SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
        this.followedSports = new HashSet<Sport>();
    }

    /*
     * [METHODS] TO BE DEFINED AS DONE IN PREVIOUS EXERCISE
     */

    /**
     * Add a new sport followed by this user: if the user already likes or does
     * the sport, nothing happens.
     * 
     * @param sport
     *            a sport followed/done by the user
     */
    public void addSport(final Sport sport) {
    	if (this.followedSports.contains(sport) == false) { 
    		this.followedSports.add(sport);
    	}
    }

    /**
     * Returns true if a user likes/does a given sport.
     * 
     * @param s
     *            sport to check
     * 
     * @return true if user likes sport s
     */
    public boolean likesSport(final Sport s) {
        return this.followedSports.contains(s);
    }

    /*
     * [METHODS] NEW METHODS TO IMPLEMENT FROM SCRATCH
     */

    /**
     * Returns the set of individual sports followed/practiced by this user: a
     * sport is individual if the number of team member is = 1.
     * 
     * @return the set of individual sport this user practices/follows
     */
    public Set<Sport> getIndividualSports() {
    	Set<Sport> returnSet = new HashSet<Sport>();
		for (Sport sport : this.followedSports) {
			if (sport.isIndividualSport() == true) {
				returnSet.add(sport);
			}
		} 
    	return returnSet;
    }

     /** 
     * Returns the set of sports which are practiced in a given place.
     * 
     * @param p the place in which the sport is practiced in order to be
     * included in the resulting set
     * 
     * @return the set of sport practiced in a given place
     */
    public Set<Sport> getSportPracticedInPlace(Place p) { 
    	Set<Sport> returnSet = new HashSet<Sport>();
		for (Sport sport : this.followedSports) {
			if (sport.getPlace() == p) {
				returnSet.add(sport);
			}
		} 
    	return returnSet;
    }
    
}

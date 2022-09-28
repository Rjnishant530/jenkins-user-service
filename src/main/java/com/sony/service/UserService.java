package com.sony.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sony.model.User;

@Service
public class UserService {

	private Map<String, User> userMap;

	public UserService() {
		super();
		userMap = new HashMap<>();

		User user;
		
		user = new User("Nishant", "Singh", "880061", "KA");
		userMap.put(user.getUuid(), user);
		user = new User("Nancy","Davolio","(206) 555-9857","Education includes a BA in psychology from Colorado State University in 1970.  She also completed \"The Art of the Cold Call.\"  Nancy is a member of Toastmasters International.");
		userMap.put(user.getUuid(), user);
		user = new User("Andrew","Fuller","(206) 555-9482","Andrew received his BTS commercial in 1974 and a Ph.D. in international marketing from the University of Dallas in 1981.  He is fluent in French and Italian and reads German.  He joined the company as a sales representative, was promoted to sales manager ");
		userMap.put(user.getUuid(), user);
		user = new User("Janet","Leverling","(206) 555-3412","Janet has a BS degree in chemistry from Boston College (1984).  She has also completed a certificate program in food retailing management.  Janet was hired as a sales associate in 1991 and promoted to sales representative in February 1992.");
		userMap.put(user.getUuid(), user);
		user = new User("Margaret","Peacock","(206) 555-8122","Margaret holds a BA in English literature from Concordia College (1958) and an MA from the American Institute of Culinary Arts (1966).  She was assigned to the London office temporarily from July through November 1992.");
		userMap.put(user.getUuid(), user);
		user = new User("Steven","Buchanan","(71) 555-4848","Steven Buchanan graduated from St. Andrews University, Scotland, with a BSC degree in 1976.  Upon joining the company as a sales representative in 1992, he spent 6 months in an orientation program at the Seattle office and then returned to his permanent p");
		userMap.put(user.getUuid(), user);
		user = new User("Michael","Suyama","(71) 555-7773","Michael is a graduate of Sussex University (MA, economics, 1983) and the University of California at Los Angeles (MBA, marketing, 1986).  He has also taken the courses \"Multi-Cultural Selling\" and \"Time Management for the Sales Professional.\"  He is fluen");
		userMap.put(user.getUuid(), user);
		user = new User("Robert","King","(71) 555-5598","Robert King served in the Peace Corps and traveled extensively before completing his degree in English at the University of Michigan in 1992, the year he joined the company.  After completing a course entitled \"Selling in Europe,\" he was transferred to th");
		userMap.put(user.getUuid(), user);
		user = new User("Laura","Callahan","(206) 555-1189","Laura received a BA in psychology from the University of Washington.  She has also completed a course in business French.  She reads and writes French.");
		userMap.put(user.getUuid(), user);
//		user = new User("Anne","Dodsworth","(71) 555-4444","Anne has a BA degree in English from St. Lawrence College.  She is fluent in French and German.");
//		userMap.put(user.getUuid(), user);


	}

	public Iterable<User> getUsers() {
		return userMap.values();
	}

	public User getUserById(String id) {
		return userMap.get(id);
	}

}

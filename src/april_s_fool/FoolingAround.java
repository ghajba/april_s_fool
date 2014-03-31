package april_s_fool;

import java.lang.reflect.Field;

/**
 * in this class I'm gonna fool around and make some Java-magick ;)
 * 
 * @author GHajba
 */
public class FoolingAround {

	public static void main(String[] args) throws Exception 
	{
		final String s1 = new StringBuilder("Welcome").toString();
		final String s2 = s1.intern();
		
		System.out.println(s1 != "Welcome");
		System.out.println(s2 == "Welcome");
		magick();
		System.out.println(s1);
		System.out.println(s2);
		
		System.out.println("-------------");
		
		integerTricks();
	}

	/*
	 * I know that it is called 'magic' and I'm referencing to occult studies of magic
	 */
	private static void magick() throws Exception
	{
		final Field field = String.class.getDeclaredField("value");
		field.setAccessible(true);
		field.set("Welcome", "Goodbye".toCharArray());
	}

	private static void integerTricks() throws ClassNotFoundException, Exception {
		final Class cls = Class.forName("java.lang.Integer$IntegerCache");
		final Field field = cls.getDeclaredField("cache");
		field.setAccessible(true);
		final Integer[] cache = (Integer[])field.get(null);
		
		cache[133] = 11;
		
		System.out.println((Integer)5 * 3);
	}
	

}

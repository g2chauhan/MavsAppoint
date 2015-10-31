package uta.mav.appoint.security;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class EncryptUtils {
   public static final String DEFAULT_ENCODING="UTF-8"; 
   static BASE64Encoder enc=new BASE64Encoder();
   static BASE64Decoder dec=new BASE64Decoder();
   
   static String key="software_design_pattern";
   public static String base64encode(String text){
      try {
         String rez = enc.encode( text.getBytes( DEFAULT_ENCODING ) );
         return rez;         
      }
      catch ( UnsupportedEncodingException e ) {
         return null;
      }
   }//base64encode

   public static String base64decode(String text){

         try {
            return new String(dec.decodeBuffer( text ),DEFAULT_ENCODING);
         }
         catch ( IOException e ) {
           return null;
         }

      }
   
   public static String encode(String content){
	   content = xorMessage(content, key);
	   return base64encode(content);
   }
   
   public static String decode(String content){
	   content = base64decode( content );
	   content = xorMessage(content,key);
	   return content;
   }

      
      public static String xorMessage(String message, String key){
       try {
          if (message==null || key==null ) return null;

         char[] keys=key.toCharArray();
         char[] mesg=message.toCharArray();

         int ml=mesg.length;
         int kl=keys.length;
         char[] newmsg=new char[ml];

         for (int i=0; i<ml; i++){
            newmsg[i]=(char)(mesg[i]^keys[i%kl]);
         }//for i
         mesg=null; keys=null;
         return new String(newmsg);
      }
      catch ( Exception e ) {
         return null;
       }  
      }//xorMessage
public static void main(String[] args) {
	String encode = encode("1001267150");
	System.out.println(encode);
	System.out.println(decode(encode));
	
	
}
}
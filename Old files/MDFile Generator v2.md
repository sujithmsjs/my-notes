# MD File Generator
Generate MD Files Automatically.

### Index
```pre
1. .classpath
2. .project
3. Application.class
4. ApplicationTest.class
5. Constants.class
6. FileInFolder.class
7. MANIFEST.MF
8. MDFile.class
9. MDFileGenerator.class
10. MDFileRepo.class
11. README.md
12. checkstyle.xml
13. org.eclipse.core.resources.prefs
14. org.eclipse.jdt.apt.core.prefs
15. org.eclipse.jdt.core.prefs
16. org.eclipse.m2e.core.prefs
17. pom.properties
18. pom.xml
19. pom.xml
20. \src\main\java\com\suji\mdfilegen\Application.java
21. \src\main\java\com\suji\mdfilegen\constants\Constants.java
22. \src\main\java\com\suji\mdfilegen\model\FileInFolder.java
23. \src\main\java\com\suji\mdfilegen\model\MDFile.java
24. \src\main\java\com\suji\mdfilegen\model\MDFileGenerator.java
25. \src\main\java\com\suji\mdfilegen\model\MDFileRepo.java
26. \src\test\java\com\suji\mdfilegen\ApplicationTest.java

```

---

### 1. .classpath

#### .classpath

```classpath

<?xml version="1.0" encoding="UTF-8"?>
<classpath>
	<classpathentry kind="src" output="target/classes" path="src/main/java">
		<attributes>
			<attribute name="optional" value="true"/>
			<attribute name="maven.pomderived" value="true"/>
		</attributes>
	</classpathentry>
	<classpathentry kind="src" output="target/test-classes" path="src/test/java">
		<attributes>
			<attribute name="optional" value="true"/>
			<attribute name="maven.pomderived" value="true"/>
			<attribute name="test" value="true"/>
		</attributes>
	</classpathentry>
	<classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-11">
		<attributes>
			<attribute name="maven.pomderived" value="true"/>
		</attributes>
	</classpathentry>
	<classpathentry kind="con" path="org.eclipse.m2e.MAVEN2_CLASSPATH_CONTAINER">
		<attributes>
			<attribute name="maven.pomderived" value="true"/>
		</attributes>
	</classpathentry>
	<classpathentry kind="src" path="target/generated-sources/annotations">
		<attributes>
			<attribute name="optional" value="true"/>
			<attribute name="maven.pomderived" value="true"/>
			<attribute name="ignore_optional_problems" value="true"/>
			<attribute name="m2e-apt" value="true"/>
		</attributes>
	</classpathentry>
	<classpathentry kind="src" output="target/test-classes" path="target/generated-test-sources/test-annotations">
		<attributes>
			<attribute name="optional" value="true"/>
			<attribute name="maven.pomderived" value="true"/>
			<attribute name="ignore_optional_problems" value="true"/>
			<attribute name="m2e-apt" value="true"/>
			<attribute name="test" value="true"/>
		</attributes>
	</classpathentry>
	<classpathentry kind="output" path="target/classes"/>
</classpath>

```

---

### 2. .project

#### .project

```project

<?xml version="1.0" encoding="UTF-8"?>
<projectDescription>
	<name>mdfilegen</name>
	<comment></comment>
	<projects>
	</projects>
	<buildSpec>
		<buildCommand>
			<name>org.eclipse.jdt.core.javabuilder</name>
			<arguments>
			</arguments>
		</buildCommand>
		<buildCommand>
			<name>org.eclipse.m2e.core.maven2Builder</name>
			<arguments>
			</arguments>
		</buildCommand>
	</buildSpec>
	<natures>
		<nature>org.eclipse.jdt.core.javanature</nature>
		<nature>org.eclipse.m2e.core.maven2Nature</nature>
	</natures>
</projectDescription>

```

---

### 3. Application.class

#### Application.class

```class

����   7 �  com/suji/mdfilegen/Application  java/lang/Object 
fileFilter Ljava/io/FileFilter; mapFiles fileRepo %Lcom/suji/mdfilegen/model/MDFileRepo; <clinit> ()V Code  #com/suji/mdfilegen/model/MDFileRepo
     <init>	    	      accept ()Ljava/io/FileFilter;	      	     LineNumberTable LocalVariableTable
   this  Lcom/suji/mdfilegen/Application; main ([Ljava/lang/String;)V % java/io/File ' E:\SpringBoot STS\mdfilegen
 $ )  * (Ljava/lang/String;)V
  , - . findAll (Ljava/io/File;)V
  0 1  showAllMdFiles
 3 5 4 (com/suji/mdfilegen/model/MDFileGenerator 6 7 write 5(Lcom/suji/mdfilegen/model/MDFileRepo;)Ljava/io/File;	 9 ; : java/lang/System < = out Ljava/io/PrintStream; ? java/lang/StringBuilder A File saved at 
 > )
 $ D E F getPath ()Ljava/lang/String;
 > H I J append -(Ljava/lang/String;)Ljava/lang/StringBuilder;
 > L M F toString
 O Q P java/io/PrintStream R * println T ______The End______ args [Ljava/lang/String; files Ljava/io/File;
 $ Z [ \ isFile ()Z ^ ` _ java/io/FileFilter  a (Ljava/io/File;)Z
 $ c d \ isDirectory
 $ f g h 	listFiles ()[Ljava/io/File; file [Ljava/io/File; theFile StackMapTable j lambda$0
 $ p q F getName s .
 u w v java/lang/String x y lastIndexOf (Ljava/lang/String;)I
 u { | } 	substring (I)Ljava/lang/String;
 u  � \ isBlank	 � � � &com/suji/mdfilegen/constants/Constants � � INCLUDE_EXTENTIONS Ljava/util/Set; � � � java/util/Set � � contains (Ljava/lang/Object;)Z f name Ljava/lang/String; I 	extention lambda$1	 � � � � MAPPER Ljava/util/List; � � � java/util/List � � iterator ()Ljava/util/Iterator; � � � java/util/Iterator � � next ()Ljava/lang/Object; � %com/suji/mdfilegen/model/FileInFolder
 � � � � getExtensions ()Ljava/util/List;
 � � � � getOrder ()I
  � � � addMD $(Ljava/io/File;ILjava/lang/String;)V
 � D
 u � � � (Ljava/lang/CharSequence;)Z
 � � � F getEx
 u � � � endsWith (Ljava/lang/String;)Z � � � \ hasNext 	theFolder 'Lcom/suji/mdfilegen/model/FileInFolder; path 
SourceFile Application.java BootstrapMethods
 � � � "java/lang/invoke/LambdaMetafactory � � metafactory �(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; � a
  � n a � a a
  � � a � a InnerClasses � %java/lang/invoke/MethodHandles$Lookup � java/lang/invoke/MethodHandles Lookup !      	     	     	  	     
      G      � Y� � �   � �   � �            
     1              /     *� �                      !   	 " #     �     =� $Y&� (L+� +� � /� � 2M� 8� >Y@� B,� C� G� K� N� 8S� N�           5 
 6  7  8  9 4 : < ;         = U V   
 3 W X   " 6 X  	 - .     �     ?*� Y� � *� ] W� -*� b� &*� eL+Y:�6>� 2M,� +����       "    >  @  D  E   G 1 H 5 G > K         ? i X      W j  1  k X  l   ! �   $ m  m  �   $  
 n a     �     3*� oL+r� t=N� 	+� zN-� -� ~� � �-� � � ��                         *    3 � X    . � �   ' x �   % � �  l    �  u u
 � a         i� �� � M� U,� � � �L*� CN+� �� -� � *+� �*� o� ��-+� �� �� -+� �� �� � *+� �+� �� ��,� � ����       * 
        # & $ 5 % 7 ) M * \ + ^  g .         i � X    H � �   C � �  l   1 �   $  �  � *  $ � � u  � &  $  �    �    � �     �  � � � �  � � � �   
  � � � 
```

---

### 4. ApplicationTest.class

#### ApplicationTest.class

```class

����   7 "  "com/suji/mdfilegen/ApplicationTest  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this $Lcom/suji/mdfilegen/ApplicationTest; 	smokeTest RuntimeVisibleAnnotations Lorg/junit/jupiter/api/Test; #Lorg/junit/jupiter/api/DisplayName; value Pointless test
    org/assertj/core/api/Assertions   
assertThat /(Z)Lorg/assertj/core/api/AbstractBooleanAssert;
    *org/assertj/core/api/AbstractBooleanAssert   	isEqualTo 
SourceFile ApplicationTest.java Application !               /     *� �    
       
                            s     8     
� � W�    
   
     	         
                   s !
```

---

### 5. Constants.class

#### Constants.class

```class

����   7 R  &com/suji/mdfilegen/constants/Constants  java/lang/Object APP_NAME Ljava/lang/String; ConstantValue 	 MD File Generator APP_DESC   Generate MD Files Automatically. SOURCE_PATH  E:\SpringBoot STS\mdfilegen INCLUDE_EXTENTIONS Ljava/util/Set; 	Signature #Ljava/util/Set<Ljava/lang/String;>; MAPPER Ljava/util/List; 9Ljava/util/List<Lcom/suji/mdfilegen/model/FileInFolder;>; DESTINATION_PATH  1C:\Users\sujit\OneDrive\Desktop\MD Files\my-notes DESTINATION_FILE_NAME  MDFile Generator v2.md <clinit> ()V Code ! .java # .xml % .properties ' ) ( java/util/Set * + of G(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Set;	  -   / java/util/ArrayList
 . 1 2  <init>	  4   6 %com/suji/mdfilegen/model/FileInFolder 8 \src\main\java\
 5 : 2 ; ((Ljava/lang/String;Ljava/lang/String;I)V = ? > java/util/List @ A add (Ljava/lang/Object;)Z C \src\test\java\ E \src\main\resources\ G .sql
 5 I 2 J (Ljava/lang/String;I)V LineNumberTable LocalVariableTable
  1 this (Lcom/suji/mdfilegen/constants/Constants; 
SourceFile Constants.java !                
                                                             �      ~ "$� &� ,� .Y� 0� 3� 3� 5Y7 � 9� < W� 3� 5YB � 9� < W� 3� 5YD$� 9� < W� 3� 5YDF� 9� < W� 3� 5Y"� H� < W�    K   "         +  @  U  j  }  L       2      /     *� M�    K       	 L        N O    P    Q
```

---

### 6. FileInFolder.class

#### FileInFolder.class

```class

����   7 x  %com/suji/mdfilegen/model/FileInFolder  java/lang/Object path Ljava/lang/String; 
extensions Ljava/util/List; 	Signature $Ljava/util/List<Ljava/lang/String;>; order I <init> '(Ljava/lang/String;Ljava/lang/String;)V Code
     ((Ljava/lang/String;Ljava/lang/String;I)V LineNumberTable LocalVariableTable this 'Lcom/suji/mdfilegen/model/FileInFolder; ex
     ()V  java/util/ArrayList
  	    	  !  	  #   % ' & java/util/List ( ) add (Ljava/lang/Object;)Z (Ljava/lang/String;I)V fileName getEx ()Ljava/lang/String; % / 0 1 get (I)Ljava/lang/Object; 3 java/lang/String getPath getExtensions ()Ljava/util/List; &()Ljava/util/List<Ljava/lang/String;>; getOrder ()I setPath (Ljava/lang/String;)V setExtensions (Ljava/util/List;)V '(Ljava/util/List<Ljava/lang/String;>;)V LocalVariableTypeTable setOrder (I)V equals
  D E ) canEqual
  G 8 9
  I 4 -
  K B )
  M 5 6 o Ljava/lang/Object; other 	this$path 
other$path this$extensions other$extensions StackMapTable hashCode
  X V 9 PRIME result $path $extensions toString _ java/lang/StringBuilder a FileInFolder(path=
 ^ c  ;
 ^ e f g append -(Ljava/lang/String;)Ljava/lang/StringBuilder; i , extensions=
 ^ k f l -(Ljava/lang/Object;)Ljava/lang/StringBuilder; n , order=
 ^ p f q (I)Ljava/lang/StringBuilder; s )
 ^ u ] - 
SourceFile FileInFolder.java !               	    
              J     *+,� �       
                                       �     %*� *� Y� � *+�  *� "*� ,� $ W�                    $     *    %       %      %      %      *     q     *� *� Y� � *� "*+�  *� �                                      +          , -     8     *� � . � 2�           $              4 -     /     *�  �                         5 6  	    7    /     *� �                         8 9     /     *� "�                         : ;     :     *+�  �                               < =  	    >    L     *+� �                              ?         
   @ A     :     *� "�                               B )         u+*� �+� � �+� M,*� C� �*� F,� F� �*� HN,� H:-� � � -� J� �*� L:,� L:� � � � J� ��               H    u       u N O   ` P   1 D Q O  7 > R O  T ! S O  Z  T O  U   ! 
�  �   �   	  E )     9     +� �                           P O   V 9     �     D;<=;h*� F`=*� HN;h-� +� -� W`=*� L:;h� +� � W`=�               4    D      A Y    ? Z    0 [ O  -  \ O  U   J � !    �     �      �        ] -     [     1� ^Y`� b*� H� dh� d*� L� jm� d*� F� or� d� t�                   1      v    w
```

---

### 7. MANIFEST.MF

#### MANIFEST.MF

```MF

Manifest-Version: 1.0
Built-By: sujit
Build-Jdk: 17.0.1
Created-By: Maven Integration for Eclipse


```

---

### 8. MDFile.class

#### MDFile.class

```class

����   7 �  com/suji/mdfilegen/model/MDFile  java/lang/Object  java/lang/Comparable order I file Ljava/io/File; title Ljava/lang/String; ex <init> (Ljava/io/File;I)V Code   
     $(Ljava/io/File;ILjava/lang/String;)V LineNumberTable LocalVariableTable this !Lcom/suji/mdfilegen/model/MDFile; 	compareTo $(Lcom/suji/mdfilegen/model/MDFile;)I	    
     ! getOrder ()I	  #  
 % ' & java/lang/String  ( (Ljava/lang/String;)I mdFile StackMapTable
  ,  - ()V	  / 	 

 1 3 2 java/io/File 4 5 getPath ()Ljava/lang/String;
 % 7 8 ( indexOf
 % : ; < 	substring (I)Ljava/lang/String;
 1 > ? 5 getName A .
 % C D ( lastIndexOf	  F   idx 	lastIndex getFile ()Ljava/io/File; getTitle getEx setOrder (I)V setFile (Ljava/io/File;)V setTitle (Ljava/lang/String;)V setEx equals (Ljava/lang/Object;)Z
  W X U canEqual
  Z I J
  \ T U
  ^ K 5
  ` L 5 o Ljava/lang/Object; other 	this$file 
other$file 
this$title other$title this$ex other$ex hashCode
  l j ! PRIME result $file $title $ex toString t java/lang/StringBuilder v MDFile(order=
 s x  R
 s z { | append (I)Ljava/lang/StringBuilder; ~ , file=
 s � { � -(Ljava/lang/String;)Ljava/lang/StringBuilder;
 s � { � -(Ljava/lang/Object;)Ljava/lang/StringBuilder; � , title= � , ex= � )
 s � r 5 (Ljava/lang/Object;)I
  �   
SourceFile MDFile.java 	Signature KLjava/lang/Object;Ljava/lang/Comparable<Lcom/suji/mdfilegen/model/MDFile;>; !            	 
                     K     	*+� �       
               	       	 	 
    	           c     $*� +� d� *� "+� "� $� *� +� d�                   $       $ )   *    H        �     @*� +*� *+� .+� 0-� 66*+� 0� 9� "+� =@� B6*+� =`� 9� E�       "       	      ! % " 0 # ? $    >    @       @ 	 
    @      @     ( G   0  H      !     /     *� �                         I J     /     *� .�                         K 5     /     *� "�                         L 5     /     *� E�                         M N     :     *� �                               O P     :     *+� .�                           	 
   Q R     :     *+� "�                               S R     :     *+� E�                               T U    F  	   �+*� �+� � �+� M,*� V� �*� ,� � �*� YN,� Y:-� � � -� [� �*� ]:,� ]:� � � � [� �*� _:,� _:� � � � [� ��               \ 	   �       � a b   � c   1 i d b  7 c e b  T F f b  Z @ g b  y ! h b    i b  *   , �  �   �   	�   	  X U     9     +� �                           c b   j !    8     _;<=;h*� `=*� YN;h-� +� -� k`=*� ]:;h� +� � k`=*� _:;h� +� � k`=�               >    _      \ m    Z n    K o b  - 2 p b  H  q b  *   w � !    �     �      �      �       �         r 5     g     =� sYu� w*� � y}� *� Y� ��� *� ]� �� *� _� �� � ��                   =    A  �     )     	*+� � ��                   �    � �    �
```

---

### 9. MDFileGenerator.class

#### MDFileGenerator.class

```class

����   7 �  (com/suji/mdfilegen/model/MDFileGenerator  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this *Lcom/suji/mdfilegen/model/MDFileGenerator; write 5(Lcom/suji/mdfilegen/model/MDFileRepo;)Ljava/io/File;  java/io/File  HC:\Users\sujit\OneDrive\Desktop\MD Files\my-notes\MDFile Generator v2.md
     (Ljava/lang/String;)V  java/io/PrintWriter
     (Ljava/io/File;)V  # MD File Generator
      println "  Generate MD Files Automatically.
  $    & 	### Index ( ```pre
 * , + #com/suji/mdfilegen/model/MDFileRepo - . getAllMdFiles ()Ljava/util/List; 0 2 1 java/util/List 3 4 iterator ()Ljava/util/Iterator; 6 8 7 java/util/Iterator 9 : next ()Ljava/lang/Object; < com/suji/mdfilegen/model/MDFile > java/lang/StringBuilder
 @ B A java/lang/String C D valueOf (I)Ljava/lang/String;
 =  G . 
 = I J K append -(Ljava/lang/String;)Ljava/lang/StringBuilder;
 ; M N O getTitle ()Ljava/lang/String;
 = Q R O toString 6 T U V hasNext ()Z X ``` Z --- \ java/io/FileReader
 ; ^ _ ` getFile ()Ljava/io/File;
 [  c java/io/BufferedReader
 b e  f (Ljava/io/Reader;)V h ### 
 = j J k (I)Ljava/lang/StringBuilder;
  m n O getName p #### 
 ; r s O getEx	 u w v java/lang/System x y out Ljava/io/PrintStream;
 { } | java/io/PrintStream ~  print (C)V
  �  � (I)V
 b � � � read ()I
  � �  flush � Is File Found: 
  � � V exists
 = � J � (Z)Ljava/lang/StringBuilder;
 { 	 u � � y err
 � � � java/io/IOException � O 
getMessage
 b � �  close
 [ �
  � repo %Lcom/suji/mdfilegen/model/MDFileRepo; dest Ljava/io/File; Ljava/io/PrintWriter; fr Ljava/io/FileReader; br Ljava/io/BufferedReader; index I mdf !Lcom/suji/mdfilegen/model/MDFile; mdFile i e Ljava/io/IOException; ex StackMapTable � java/lang/Throwable 
SourceFile MDFileGenerator.java !               /     *� �    
                    	      �    �� Y� LMN:� Y+� M,� ,!� ,� #,%� ,'� 6*� )� / :� 2� 5 � ;:,� =Y�� ?� EF� H� L� H� P� � S ���,� #,W� ,� #,Y� ,� #6*� )� / :� �� 5 � ;:� [Y� ]� aN� bY-� d:,� =Yg� E�� iF� H� ]� l� H� P� ,� #,� =Yo� E� L� H� P� ,� #,� =YW� E� q� H� P� ,� #� � t�� z,�� �� �Y6���,� #,W� ,� #,Y� ,� #,� �� S ��7� t� =Y�� E+� �� �� P� �� R:� �� �� �� �-� �,� �� R:
� �
� �� �� B:	� �-� �,� �� :
� �
� �� �	�� �-� �,� �� :
� �
� �� �+�  �� ���� � ��  ��� ���� �  
   � =    
             &  *  0   6 ! 9 # S $ v # � & � ' � ( � ) � * � , � - � / � 1 � 3 � 4 � 5 6 7, 80 ;3 << =C ;O ?S @Y A] Bc Cg Ek -u H� J� K� N� O� P� Q� R� L� N� O� P� Q� R� T� N� O� P� Q� R� U    �   � � �   
� � �  � x �  � � �  � � �  9U � �  S # � �  � � � � 3  � � K   � � �  � � �  � � 
�  � � 
�  � � 
 �   � � G  *   [ b  6  .2� � 	 *   [ b ; 6  � � '  *   [ b  6  � %  *   [ b  �\ �O ��  
 *   [ b     �  ��   *   [ b  O �  �    �
```

---

### 10. MDFileRepo.class

#### MDFileRepo.class

```class

����   7 d  #com/suji/mdfilegen/model/MDFileRepo  java/lang/Object files Ljava/util/List; 	Signature 3Ljava/util/List<Lcom/suji/mdfilegen/model/MDFile;>; <init> ()V Code
   	 
  java/util/ArrayList
  	     LineNumberTable LocalVariableTable this %Lcom/suji/mdfilegen/model/MDFileRepo; addMD $(Lcom/suji/mdfilegen/model/MDFile;)V    java/util/List   add (Ljava/lang/Object;)Z md !Lcom/suji/mdfilegen/model/MDFile; getAllMdFiles ()Ljava/util/List; 5()Ljava/util/List<Lcom/suji/mdfilegen/model/MDFile;>; (Ljava/io/File;I)V & com/suji/mdfilegen/model/MDFile
 % ( 	 $ file Ljava/io/File; order I $(Ljava/io/File;ILjava/lang/String;)V
 % / 	 - title Ljava/lang/String; showAllMdFiles
 4 6 5 java/util/Collections 7 8 sort (Ljava/util/List;)V	 : < ; java/lang/System = > out Ljava/io/PrintStream;
  @ A B getClass ()Ljava/lang/Class;   D E F accept 4(Ljava/io/PrintStream;)Ljava/util/function/Consumer;  H I J forEach  (Ljava/util/function/Consumer;)V 
SourceFile MDFileRepo.java BootstrapMethods
 O Q P "java/lang/invoke/LambdaMetafactory R S metafactory �(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite; N (Ljava/lang/Object;)V U
 X Z Y java/io/PrintStream [ U println W  InnerClasses ` %java/lang/invoke/MethodHandles$Lookup b java/lang/invoke/MethodHandles Lookup !                 	 
     B     *� *� Y� � �             	                      D     *� +�  W�       
                           ! "      #    /     *� �                          $     V     *� � %Y+� '�  W�       
                       ) *     + ,    -     a     *� � %Y+-� .�  W�       
          *            ) *     + ,     0 1   2 
     P     *� � 3*� � 9Y� ?W� C  � G �                             K    L M     T  V \ ] ^   
  _ a c 
```

---

### 11. README.md

#### README.md

```md

# README

Java 11 base application.

## BASE SETUP

### Dependencies

* Junit 5
* AssertJ
* Mockito

### Support

* general GitIgnore file generated using [gitignore.io](https://www.gitignore.io)
* checkstyle with [google java style](https://checkstyle.sourceforge.io/google_style.html)

### License, copyright and header

Automatically update license header and copyright header in each src file, default license is:

* MIT License

Easily changed in the POM select from a list of available licenses.

To see what is available:

```bash
  mvn license:license-list
```

To see the license details:

```bash
  mvn license:license-list -Ddetail
```

```

---

### 12. checkstyle.xml

#### checkstyle.xml

```xml

<?xml version="1.0"?>
<!DOCTYPE module PUBLIC
          "-//Checkstyle//DTD Checkstyle Configuration 1.3//EN"
          "https://checkstyle.org/dtds/configuration_1_3.dtd">

<!--
    Checkstyle configuration that checks the Google coding conventions from Google Java Style
    that can be found at https://google.github.io/styleguide/javaguide.html

    Checkstyle is very configurable. Be sure to read the documentation at
    http://checkstyle.org (or in your downloaded distribution).

    To completely disable a check, just comment it out or delete it from the file.
    To suppress certain violations please review suppression filters.

    Authors: Max Vetrenko, Ruslan Diachenko, Roman Ivanov.
 -->

<module name = "Checker">
  <property name="charset" value="UTF-8"/>

  <property name="severity" value="warning"/>

  <property name="fileExtensions" value="java, properties, xml"/>
  <!-- Excludes all 'module-info.java' files              -->
  <!-- See https://checkstyle.org/config_filefilters.html -->
  <module name="BeforeExecutionExclusionFileFilter">
    <property name="fileNamePattern" value="module\-info\.java$"/>
  </module>

  <!-- Checks for whitespace                               -->
  <!-- See http://checkstyle.org/config_whitespace.html -->
  <module name="FileTabCharacter">
    <property name="eachLine" value="true"/>
  </module>

  <module name="LineLength">
    <property name="fileExtensions" value="java"/>
    <property name="max" value="100"/>
    <property name="ignorePattern" value="^package.*|^import.*|a href|href|http://|https://|ftp://"/>
  </module>

  <module name="TreeWalker">
    <module name="OuterTypeFilename"/>
    <module name="IllegalTokenText">
      <property name="tokens" value="STRING_LITERAL, CHAR_LITERAL"/>
      <property name="format" value="\\u00(09|0(a|A)|0(c|C)|0(d|D)|22|27|5(C|c))|\\(0(10|11|12|14|15|42|47)|134)"/>
      <property name="message" value="Consider using special escape sequence instead of octal value or Unicode escaped value."/>
    </module>
    <module name="AvoidEscapedUnicodeCharacters">
      <property name="allowEscapesForControlCharacters" value="true"/>
      <property name="allowByTailComment" value="true"/>
      <property name="allowNonPrintableEscapes" value="true"/>
    </module>
    <module name="AvoidStarImport"/>
    <module name="OneTopLevelClass"/>
    <module name="NoLineWrap">
      <property name="tokens" value="PACKAGE_DEF, IMPORT, STATIC_IMPORT"/>
    </module>
    <module name="EmptyBlock">
      <property name="option" value="TEXT"/>
      <property name="tokens" value="LITERAL_TRY, LITERAL_FINALLY, LITERAL_IF, LITERAL_ELSE, LITERAL_SWITCH"/>
    </module>
    <module name="NeedBraces">
      <property name="tokens" value="LITERAL_DO, LITERAL_ELSE, LITERAL_FOR, LITERAL_IF, LITERAL_WHILE"/>
    </module>
    <module name="LeftCurly">
      <property name="tokens" value="ANNOTATION_DEF, CLASS_DEF, CTOR_DEF, ENUM_CONSTANT_DEF, ENUM_DEF,
                    INTERFACE_DEF, LAMBDA, LITERAL_CASE, LITERAL_CATCH, LITERAL_DEFAULT,
                    LITERAL_DO, LITERAL_ELSE, LITERAL_FINALLY, LITERAL_FOR, LITERAL_IF,
                    LITERAL_SWITCH, LITERAL_SYNCHRONIZED, LITERAL_TRY, LITERAL_WHILE, METHOD_DEF,
                    OBJBLOCK, STATIC_INIT"/>
    </module>
    <module name="RightCurly">
      <property name="id" value="RightCurlySame"/>
      <property name="tokens" value="LITERAL_TRY, LITERAL_CATCH, LITERAL_FINALLY, LITERAL_IF, LITERAL_ELSE,
                    LITERAL_DO"/>
    </module>
    <module name="RightCurly">
      <property name="id" value="RightCurlyAlone"/>
      <property name="option" value="alone"/>
      <property name="tokens" value="CLASS_DEF, METHOD_DEF, CTOR_DEF, LITERAL_FOR, LITERAL_WHILE, STATIC_INIT,
                    INSTANCE_INIT, ANNOTATION_DEF, ENUM_DEF"/>
    </module>
    <module name="SuppressionXpathSingleFilter">
      <!-- suppresion is required till https://github.com/checkstyle/checkstyle/issues/7541 -->
      <property name="id" value="RightCurlyAlone"/>
      <property name="query" value="//RCURLY[parent::SLIST[count(./*)=1]
                                                 or preceding-sibling::*[last()][self::LCURLY]]"/>
    </module>
    <module name="WhitespaceAround">
      <property name="allowEmptyConstructors" value="true"/>
      <property name="allowEmptyLambdas" value="true"/>
      <property name="allowEmptyMethods" value="true"/>
      <property name="allowEmptyTypes" value="true"/>
      <property name="allowEmptyLoops" value="true"/>
      <property name="tokens" value="ASSIGN, BAND, BAND_ASSIGN, BOR, BOR_ASSIGN, BSR, BSR_ASSIGN, BXOR,
                    BXOR_ASSIGN, COLON, DIV, DIV_ASSIGN, DO_WHILE, EQUAL, GE, GT, LAMBDA, LAND,
                    LCURLY, LE, LITERAL_CATCH, LITERAL_DO, LITERAL_ELSE, LITERAL_FINALLY,
                    LITERAL_FOR, LITERAL_IF, LITERAL_RETURN, LITERAL_SWITCH, LITERAL_SYNCHRONIZED,
                     LITERAL_TRY, LITERAL_WHILE, LOR, LT, MINUS, MINUS_ASSIGN, MOD, MOD_ASSIGN,
                     NOT_EQUAL, PLUS, PLUS_ASSIGN, QUESTION, RCURLY, SL, SLIST, SL_ASSIGN, SR,
                     SR_ASSIGN, STAR, STAR_ASSIGN, LITERAL_ASSERT, TYPE_EXTENSION_AND"/>
      <message key="ws.notFollowed" value="WhitespaceAround: ''{0}'' is not followed by whitespace. Empty blocks may only be represented as '{}' when not part of a multi-block statement (4.1.3)"/>
      <message key="ws.notPreceded" value="WhitespaceAround: ''{0}'' is not preceded with whitespace."/>
    </module>
    <module name="OneStatementPerLine"/>
    <module name="MultipleVariableDeclarations"/>
    <module name="ArrayTypeStyle"/>
    <module name="MissingSwitchDefault"/>
    <module name="FallThrough"/>
    <module name="UpperEll"/>
    <module name="ModifierOrder"/>
    <module name="EmptyLineSeparator">
      <property name="tokens" value="PACKAGE_DEF, IMPORT, STATIC_IMPORT, CLASS_DEF, INTERFACE_DEF, ENUM_DEF,
                    STATIC_INIT, INSTANCE_INIT, METHOD_DEF, CTOR_DEF, VARIABLE_DEF"/>
      <property name="allowNoEmptyLineBetweenFields" value="true"/>
    </module>
    <module name="SeparatorWrap">
      <property name="id" value="SeparatorWrapDot"/>
      <property name="tokens" value="DOT"/>
      <property name="option" value="nl"/>
    </module>
    <module name="SeparatorWrap">
      <property name="id" value="SeparatorWrapComma"/>
      <property name="tokens" value="COMMA"/>
      <property name="option" value="EOL"/>
    </module>
    <module name="SeparatorWrap">
      <!-- ELLIPSIS is EOL until https://github.com/google/styleguide/issues/258 -->
      <property name="id" value="SeparatorWrapEllipsis"/>
      <property name="tokens" value="ELLIPSIS"/>
      <property name="option" value="EOL"/>
    </module>
    <module name="SeparatorWrap">
      <!-- ARRAY_DECLARATOR is EOL until https://github.com/google/styleguide/issues/259 -->
      <property name="id" value="SeparatorWrapArrayDeclarator"/>
      <property name="tokens" value="ARRAY_DECLARATOR"/>
      <property name="option" value="EOL"/>
    </module>
    <module name="SeparatorWrap">
      <property name="id" value="SeparatorWrapMethodRef"/>
      <property name="tokens" value="METHOD_REF"/>
      <property name="option" value="nl"/>
    </module>
    <module name="PackageName">
      <property name="format" value="^[a-z]+(\.[a-z][a-z0-9]*)*$"/>
      <message key="name.invalidPattern" value="Package name ''{0}'' must match pattern ''{1}''."/>
    </module>
    <module name="TypeName">
      <property name="tokens" value="CLASS_DEF, INTERFACE_DEF, ENUM_DEF, ANNOTATION_DEF"/>
      <message key="name.invalidPattern" value="Type name ''{0}'' must match pattern ''{1}''."/>
    </module>
    <module name="MemberName">
      <property name="format" value="^[a-z][a-z0-9][a-zA-Z0-9]*$"/>
      <message key="name.invalidPattern" value="Member name ''{0}'' must match pattern ''{1}''."/>
    </module>
    <module name="ParameterName">
      <property name="format" value="^[a-z]([a-z0-9][a-zA-Z0-9]*)?$"/>
      <message key="name.invalidPattern" value="Parameter name ''{0}'' must match pattern ''{1}''."/>
    </module>
    <module name="LambdaParameterName">
      <property name="format" value="^[a-z]([a-z0-9][a-zA-Z0-9]*)?$"/>
      <message key="name.invalidPattern" value="Lambda parameter name ''{0}'' must match pattern ''{1}''."/>
    </module>
    <module name="CatchParameterName">
      <property name="format" value="^[a-z]([a-z0-9][a-zA-Z0-9]*)?$"/>
      <message key="name.invalidPattern" value="Catch parameter name ''{0}'' must match pattern ''{1}''."/>
    </module>
    <module name="LocalVariableName">
      <property name="format" value="^[a-z]([a-z0-9][a-zA-Z0-9]*)?$"/>
      <message key="name.invalidPattern" value="Local variable name ''{0}'' must match pattern ''{1}''."/>
    </module>
    <module name="ClassTypeParameterName">
      <property name="format" value="(^[A-Z][0-9]?)$|([A-Z][a-zA-Z0-9]*[T]$)"/>
      <message key="name.invalidPattern" value="Class type name ''{0}'' must match pattern ''{1}''."/>
    </module>
    <module name="MethodTypeParameterName">
      <property name="format" value="(^[A-Z][0-9]?)$|([A-Z][a-zA-Z0-9]*[T]$)"/>
      <message key="name.invalidPattern" value="Method type name ''{0}'' must match pattern ''{1}''."/>
    </module>
    <module name="InterfaceTypeParameterName">
      <property name="format" value="(^[A-Z][0-9]?)$|([A-Z][a-zA-Z0-9]*[T]$)"/>
      <message key="name.invalidPattern" value="Interface type name ''{0}'' must match pattern ''{1}''."/>
    </module>
    <module name="NoFinalizer"/>
    <module name="GenericWhitespace">
      <message key="ws.followed" value="GenericWhitespace ''{0}'' is followed by whitespace."/>
      <message key="ws.preceded" value="GenericWhitespace ''{0}'' is preceded with whitespace."/>
      <message key="ws.illegalFollow" value="GenericWhitespace ''{0}'' should followed by whitespace."/>
      <message key="ws.notPreceded" value="GenericWhitespace ''{0}'' is not preceded with whitespace."/>
    </module>
    <module name="Indentation">
      <property name="basicOffset" value="2"/>
      <property name="braceAdjustment" value="0"/>
      <property name="caseIndent" value="2"/>
      <property name="throwsIndent" value="4"/>
      <property name="lineWrappingIndentation" value="4"/>
      <property name="arrayInitIndent" value="2"/>
    </module>
    <module name="AbbreviationAsWordInName">
      <property name="ignoreFinal" value="false"/>
      <property name="allowedAbbreviationLength" value="1"/>
      <property name="tokens" value="CLASS_DEF, INTERFACE_DEF, ENUM_DEF, ANNOTATION_DEF, ANNOTATION_FIELD_DEF,
                    PARAMETER_DEF, VARIABLE_DEF, METHOD_DEF"/>
    </module>
    <module name="OverloadMethodsDeclarationOrder"/>
    <module name="VariableDeclarationUsageDistance"/>
    <module name="CustomImportOrder">
      <property name="sortImportsInGroupAlphabetically" value="true"/>
      <property name="separateLineBetweenGroups" value="true"/>
      <property name="tokens" value="IMPORT, STATIC_IMPORT, PACKAGE_DEF"/>
    </module>
    <module name="MethodParamPad">
      <property name="tokens" value="CTOR_DEF, LITERAL_NEW, METHOD_CALL, METHOD_DEF,
                    SUPER_CTOR_CALL, ENUM_CONSTANT_DEF"/>
    </module>
    <module name="NoWhitespaceBefore">
      <property name="tokens" value="COMMA, SEMI, POST_INC, POST_DEC, DOT, ELLIPSIS, METHOD_REF"/>
      <property name="allowLineBreaks" value="true"/>
    </module>
    <module name="ParenPad">
      <property name="tokens" value="ANNOTATION, ANNOTATION_FIELD_DEF, CTOR_CALL, CTOR_DEF, DOT, ENUM_CONSTANT_DEF,
                    EXPR, LITERAL_CATCH, LITERAL_DO, LITERAL_FOR, LITERAL_IF, LITERAL_NEW,
                    LITERAL_SWITCH, LITERAL_SYNCHRONIZED, LITERAL_WHILE, METHOD_CALL,
                    METHOD_DEF, QUESTION, RESOURCE_SPECIFICATION, SUPER_CTOR_CALL, LAMBDA"/>
    </module>
    <module name="OperatorWrap">
      <property name="option" value="NL"/>
      <property name="tokens" value="BAND, BOR, BSR, BXOR, DIV, EQUAL, GE, GT, LAND, LE, LITERAL_INSTANCEOF, LOR,
                    LT, MINUS, MOD, NOT_EQUAL, PLUS, QUESTION, SL, SR, STAR, METHOD_REF "/>
    </module>
    <module name="AnnotationLocation">
      <property name="id" value="AnnotationLocationMostCases"/>
      <property name="tokens" value="CLASS_DEF, INTERFACE_DEF, ENUM_DEF, METHOD_DEF, CTOR_DEF"/>
    </module>
    <module name="AnnotationLocation">
      <property name="id" value="AnnotationLocationVariables"/>
      <property name="tokens" value="VARIABLE_DEF"/>
      <property name="allowSamelineMultipleAnnotations" value="true"/>
    </module>
    <module name="NonEmptyAtclauseDescription"/>
    <module name="InvalidJavadocPosition"/>
    <module name="JavadocTagContinuationIndentation"/>
    <module name="SummaryJavadoc">
      <property name="forbiddenSummaryFragments" value="^@return the *|^This method returns |^A [{]@code [a-zA-Z0-9]+[}]( is a )"/>
    </module>
    <module name="JavadocParagraph"/>
    <module name="AtclauseOrder">
      <property name="tagOrder" value="@param, @return, @throws, @deprecated"/>
      <property name="target" value="CLASS_DEF, INTERFACE_DEF, ENUM_DEF, METHOD_DEF, CTOR_DEF, VARIABLE_DEF"/>
    </module>
    <module name="JavadocMethod">
      <property name="scope" value="public"/>
      <property name="allowMissingParamTags" value="true"/>
      <property name="allowMissingReturnTag" value="true"/>
      <property name="allowedAnnotations" value="Override, Test"/>
      <property name="tokens" value="METHOD_DEF, CTOR_DEF, ANNOTATION_FIELD_DEF"/>
    </module>
    <module name="MissingJavadocMethod">
      <property name="scope" value="public"/>
      <property name="minLineCount" value="2"/>
      <property name="allowedAnnotations" value="Override, Test"/>
      <property name="tokens" value="METHOD_DEF, CTOR_DEF, ANNOTATION_FIELD_DEF"/>
    </module>
    <module name="MethodName">
      <property name="format" value="^[a-z][a-z0-9][a-zA-Z0-9_]*$"/>
      <message key="name.invalidPattern" value="Method name ''{0}'' must match pattern ''{1}''."/>
    </module>
    <module name="SingleLineJavadoc">
      <property name="ignoreInlineTags" value="false"/>
    </module>
    <module name="EmptyCatchBlock">
      <property name="exceptionVariableName" value="expected"/>
    </module>
    <module name="CommentsIndentation">
      <property name="tokens" value="SINGLE_LINE_COMMENT, BLOCK_COMMENT_BEGIN"/>
    </module>
  </module>
</module>

```

---

### 13. org.eclipse.core.resources.prefs

#### org.eclipse.core.resources.prefs

```prefs

eclipse.preferences.version=1
encoding//src/main/java=UTF-8
encoding//src/test/java=UTF-8
encoding/<project>=UTF-8

```

---

### 14. org.eclipse.jdt.apt.core.prefs

#### org.eclipse.jdt.apt.core.prefs

```prefs

eclipse.preferences.version=1
org.eclipse.jdt.apt.aptEnabled=false

```

---

### 15. org.eclipse.jdt.core.prefs

#### org.eclipse.jdt.core.prefs

```prefs

eclipse.preferences.version=1
org.eclipse.jdt.core.compiler.codegen.targetPlatform=11
org.eclipse.jdt.core.compiler.compliance=11
org.eclipse.jdt.core.compiler.problem.enablePreviewFeatures=disabled
org.eclipse.jdt.core.compiler.problem.forbiddenReference=warning
org.eclipse.jdt.core.compiler.problem.reportPreviewFeatures=ignore
org.eclipse.jdt.core.compiler.processAnnotations=disabled
org.eclipse.jdt.core.compiler.release=enabled
org.eclipse.jdt.core.compiler.source=11

```

---

### 16. org.eclipse.m2e.core.prefs

#### org.eclipse.m2e.core.prefs

```prefs

activeProfiles=
eclipse.preferences.version=1
resolveWorkspaceProjects=true
version=1

```

---

### 17. pom.properties

#### pom.properties

```properties

#Generated by Maven Integration for Eclipse
#Wed Jul 27 21:36:53 IST 2022
m2e.projectLocation=E\:\\SpringBoot STS\\mdfilegen
m2e.projectName=mdfilegen
groupId=com.suji
artifactId=mdfilegen
version=0.0.1-SNAPSHOT

```

---

### 18. pom.xml

#### pom.xml

```xml

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                      http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.suji</groupId>
	<artifactId>mdfilegen</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>Java 11 Application</name>
	<inceptionYear>2020</inceptionYear>
	<organization>
		<name>Organization Name</name>
	</organization>

	<properties>
		<java.version>11</java.version>
		<maven.compiler.source>${java.version}</maven.compiler.source>
		<maven.compiler.target>${java.version}</maven.compiler.target>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
	</properties>

	<dependencies>

		<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>1.18.24</version>
			<scope>provided</scope>
		</dependency>


		<!-- Test Dependencies -->


		<dependency>
			<groupId>org.junit.jupiter</groupId>
			<artifactId>junit-jupiter</artifactId>
			<version>5.6.0</version>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.assertj</groupId>
			<artifactId>assertj-core</artifactId>
			<version>3.15.0</version>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.mockito</groupId>
			<artifactId>mockito-core</artifactId>
			<version>3.3.0</version>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<!-- BUILD -->
	<build>
		<pluginManagement>
			<!-- lock down plugins versions to avoid using Maven defaults (may be 
				moved to parent pom) -->
			<plugins>
				<!-- clean lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#clean_Lifecycle -->
				<plugin>
					<artifactId>maven-clean-plugin</artifactId>
					<version>3.1.0</version>
				</plugin>
				<!-- default lifecycle, jar packaging: see https://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_jar_packaging -->
				<plugin>
					<artifactId>maven-resources-plugin</artifactId>
					<version>3.0.2</version>
				</plugin>
				<plugin>
					<artifactId>maven-compiler-plugin</artifactId>
					<version>3.8.0</version>
				</plugin>
				<plugin>
					<artifactId>maven-surefire-plugin</artifactId>
					<version>2.22.0</version>
				</plugin>
				<plugin>
					<artifactId>maven-jar-plugin</artifactId>
					<version>3.0.2</version>
				</plugin>
				<plugin>
					<artifactId>maven-install-plugin</artifactId>
					<version>2.5.2</version>
				</plugin>
				<plugin>
					<artifactId>maven-deploy-plugin</artifactId>
					<version>2.8.2</version>
				</plugin>
				<!-- site lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#site_Lifecycle -->
				<plugin>
					<artifactId>maven-site-plugin</artifactId>
					<version>3.7.1</version>
				</plugin>
				<plugin>
					<artifactId>maven-project-info-reports-plugin</artifactId>
					<version>3.0.0</version>
				</plugin>
			</plugins>
		</pluginManagement>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.8.0</version>
				<configuration>
					<release>11</release>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-surefire-plugin</artifactId>
				<version>2.22.0</version>
				<configuration>
					<argLine> --illegal-access=permit</argLine>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-failsafe-plugin</artifactId>
				<version>2.22.0</version>
				<configuration>
					<argLine> --illegal-access=permit</argLine>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.codehaus.mojo</groupId>
				<artifactId>license-maven-plugin</artifactId>
				<version>2.0.0</version>
				<executions>
					<execution>
						<id>first</id>
						<goals>
							<goal>update-file-header</goal>
						</goals>
						<phase>process-sources</phase>
						<configuration>
							<licenseName>mit</licenseName>
							<sectionDelimiter>------</sectionDelimiter>
							<canUpdateCopyright>true</canUpdateCopyright>
							<canUpdateDescription>true</canUpdateDescription>
							<processEndTag>=====LICENSE-END=====</processEndTag>
							<processStartTag>=====LICENSE-START=====</processStartTag>
							<addJavaLicenseAfterPackage>false</addJavaLicenseAfterPackage>
							<roots>
								<root>src/main/java</root>
								<root>src/test</root>
							</roots>
						</configuration>
					</execution>
				</executions>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-checkstyle-plugin</artifactId>
				<version>3.1.1</version>
				<configuration>
					<configLocation>checkstyle.xml</configLocation>
					<encoding>UTF-8</encoding>
					<consoleOutput>true</consoleOutput>
					<failsOnError>true</failsOnError>
					<linkXRef>false</linkXRef>
				</configuration>
				<executions>
					<execution>
						<id>checkstyle</id>
						<phase>test</phase>
						<goals>
							<goal>check</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>

	<!-- REPORTING -->
	<reporting>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-checkstyle-plugin</artifactId>
				<version>3.1.1</version>
				<configuration>
					<configLocation>checkstyle.xml</configLocation>
				</configuration>
				<reportSets>
					<reportSet>
						<reports>
							<report>checkstyle</report>
						</reports>
					</reportSet>
				</reportSets>
			</plugin>
		</plugins>
	</reporting>
</project>
```

---

### 19. pom.xml

#### pom.xml

```xml

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
                      http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.suji</groupId>
	<artifactId>mdfilegen</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>Java 11 Application</name>
	<inceptionYear>2020</inceptionYear>
	<organization>
		<name>Organization Name</name>
	</organization>

	<properties>
		<java.version>11</java.version>
		<maven.compiler.source>${java.version}</maven.compiler.source>
		<maven.compiler.target>${java.version}</maven.compiler.target>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
	</properties>

	<dependencies>

		<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>1.18.24</version>
			<scope>provided</scope>
		</dependency>


		<!-- Test Dependencies -->


		<dependency>
			<groupId>org.junit.jupiter</groupId>
			<artifactId>junit-jupiter</artifactId>
			<version>5.6.0</version>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.assertj</groupId>
			<artifactId>assertj-core</artifactId>
			<version>3.15.0</version>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.mockito</groupId>
			<artifactId>mockito-core</artifactId>
			<version>3.3.0</version>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<!-- BUILD -->
	<build>
		<pluginManagement>
			<!-- lock down plugins versions to avoid using Maven defaults (may be 
				moved to parent pom) -->
			<plugins>
				<!-- clean lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#clean_Lifecycle -->
				<plugin>
					<artifactId>maven-clean-plugin</artifactId>
					<version>3.1.0</version>
				</plugin>
				<!-- default lifecycle, jar packaging: see https://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_jar_packaging -->
				<plugin>
					<artifactId>maven-resources-plugin</artifactId>
					<version>3.0.2</version>
				</plugin>
				<plugin>
					<artifactId>maven-compiler-plugin</artifactId>
					<version>3.8.0</version>
				</plugin>
				<plugin>
					<artifactId>maven-surefire-plugin</artifactId>
					<version>2.22.0</version>
				</plugin>
				<plugin>
					<artifactId>maven-jar-plugin</artifactId>
					<version>3.0.2</version>
				</plugin>
				<plugin>
					<artifactId>maven-install-plugin</artifactId>
					<version>2.5.2</version>
				</plugin>
				<plugin>
					<artifactId>maven-deploy-plugin</artifactId>
					<version>2.8.2</version>
				</plugin>
				<!-- site lifecycle, see https://maven.apache.org/ref/current/maven-core/lifecycles.html#site_Lifecycle -->
				<plugin>
					<artifactId>maven-site-plugin</artifactId>
					<version>3.7.1</version>
				</plugin>
				<plugin>
					<artifactId>maven-project-info-reports-plugin</artifactId>
					<version>3.0.0</version>
				</plugin>
			</plugins>
		</pluginManagement>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.8.0</version>
				<configuration>
					<release>11</release>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-surefire-plugin</artifactId>
				<version>2.22.0</version>
				<configuration>
					<argLine> --illegal-access=permit</argLine>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-failsafe-plugin</artifactId>
				<version>2.22.0</version>
				<configuration>
					<argLine> --illegal-access=permit</argLine>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.codehaus.mojo</groupId>
				<artifactId>license-maven-plugin</artifactId>
				<version>2.0.0</version>
				<executions>
					<execution>
						<id>first</id>
						<goals>
							<goal>update-file-header</goal>
						</goals>
						<phase>process-sources</phase>
						<configuration>
							<licenseName>mit</licenseName>
							<sectionDelimiter>------</sectionDelimiter>
							<canUpdateCopyright>true</canUpdateCopyright>
							<canUpdateDescription>true</canUpdateDescription>
							<processEndTag>=====LICENSE-END=====</processEndTag>
							<processStartTag>=====LICENSE-START=====</processStartTag>
							<addJavaLicenseAfterPackage>false</addJavaLicenseAfterPackage>
							<roots>
								<root>src/main/java</root>
								<root>src/test</root>
							</roots>
						</configuration>
					</execution>
				</executions>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-checkstyle-plugin</artifactId>
				<version>3.1.1</version>
				<configuration>
					<configLocation>checkstyle.xml</configLocation>
					<encoding>UTF-8</encoding>
					<consoleOutput>true</consoleOutput>
					<failsOnError>true</failsOnError>
					<linkXRef>false</linkXRef>
				</configuration>
				<executions>
					<execution>
						<id>checkstyle</id>
						<phase>test</phase>
						<goals>
							<goal>check</goal>
						</goals>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>

	<!-- REPORTING -->
	<reporting>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-checkstyle-plugin</artifactId>
				<version>3.1.1</version>
				<configuration>
					<configLocation>checkstyle.xml</configLocation>
				</configuration>
				<reportSets>
					<reportSet>
						<reports>
							<report>checkstyle</report>
						</reports>
					</reportSet>
				</reportSets>
			</plugin>
		</plugins>
	</reporting>
</project>
```

---

### 20. Application.java

#### \src\main\java\com\suji\mdfilegen\Application.java

```java


package com.suji.mdfilegen;

import java.io.File;
import java.io.FileFilter;

import com.suji.mdfilegen.constants.Constants;
import com.suji.mdfilegen.model.FileInFolder;
import com.suji.mdfilegen.model.MDFileGenerator;
import com.suji.mdfilegen.model.MDFileRepo;

public class Application {

	public static FileFilter fileFilter;
	public static FileFilter mapFiles;
	public static MDFileRepo fileRepo = new MDFileRepo();
	
	static {

		fileFilter = f -> {
			String name = f.getName();
			int lastIndexOf = name.lastIndexOf(".");
			String extention = null;
			if (lastIndexOf > 0)
				extention = name.substring(lastIndexOf);
			return extention != null && !extention.isBlank() && Constants.INCLUDE_EXTENTIONS.contains(extention);
		};

		mapFiles = f -> {
			for (FileInFolder theFolder : Constants.MAPPER) {

				String path = f.getPath();
				
				// For Root Folder Files
				if(theFolder.getExtensions() == null && path != null) {
					fileRepo.addMD(f, theFolder.getOrder(), f.getName());
					return true;
				}
				
				// For Default Folder Files
				if (path.contains(theFolder.getPath()) && path.endsWith(theFolder.getEx())) {
					fileRepo.addMD(f, theFolder.getOrder(), theFolder.getPath());
					return true;
				}
			}
			return false;
		};

	}

	public static void main(String[] args) {

		File files = new File(Constants.SOURCE_PATH);
		findAll(files);
		fileRepo.showAllMdFiles();
		File write = MDFileGenerator.write(fileRepo);
		System.out.println("File saved at "+write.getPath());
		System.out.println("______The End______");
	}

	public static void findAll(File file) {
		if (file.isFile()) {

			if (mapFiles.accept(file)) {
				//System.out.println("\t- " + file.getPath());
			}

		} else if (file.isDirectory()) {
			File[] files = file.listFiles();

			for (File theFile : files) {
				findAll(theFile);
			}
		}
	}

}

```

---

### 21. Constants.java

#### \src\main\java\com\suji\mdfilegen\constants\Constants.java

```java

package com.suji.mdfilegen.constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.suji.mdfilegen.model.FileInFolder;

public class Constants {
	
	public static final String APP_NAME = "MD File Generator";
	public static final String APP_DESC = "Generate MD Files Automatically.";
	
	public static final String SOURCE_PATH = "E:\\SpringBoot STS\\mdfilegen"; //"S:\\git\\mongo-restapi";
	public static final Set<String> INCLUDE_EXTENTIONS = Set.of(".java", ".xml", ".properties");
	public static final List<FileInFolder> MAPPER = new ArrayList<>();
	
	public static final String DESTINATION_PATH = "C:\\Users\\sujit\\OneDrive\\Desktop\\MD Files\\my-notes";
	
	public static final String DESTINATION_FILE_NAME = "MDFile Generator v2.md";
	
	
	static {
		
		MAPPER.add(new FileInFolder("\\src\\main\\java\\", ".java", 2));
		MAPPER.add(new FileInFolder("\\src\\test\\java\\", ".java", 3));
		MAPPER.add(new FileInFolder("\\src\\main\\resources\\", ".properties", 0));
		MAPPER.add(new FileInFolder("\\src\\main\\resources\\", ".sql", 1));
		MAPPER.add(new FileInFolder(".xml", 1));
		
	}
}

```

---

### 22. FileInFolder.java

#### \src\main\java\com\suji\mdfilegen\model\FileInFolder.java

```java

package com.suji.mdfilegen.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data

public class FileInFolder {

	private String path;
	private List<String> extensions = new ArrayList<>();	
	private int order;
	
	public FileInFolder(String path, String ex) {
		this(path, ex, 0);
	}
	
	public FileInFolder(String path, String ex, int order) {
		this.path = path;
		this.order = order;
		extensions.add(ex);
	}
	
	public FileInFolder(String fileName, int order) {
		this.order = order;
		path = fileName;
		extensions = null;
	}
	
	
	
	
	public String getEx() {
		return extensions.get(0);
	}
}

```

---

### 23. MDFile.java

#### \src\main\java\com\suji\mdfilegen\model\MDFile.java

```java

package com.suji.mdfilegen.model;

import java.io.File;

import lombok.Data;

@Data
public class MDFile implements Comparable<MDFile> {
	
	private int order;
	private File file;
	private String title;
	private String ex;
	
	public MDFile(File file, int order) {
		this(file, order, "");
	}
	
	
	
	@Override
	public int compareTo(MDFile mdFile) {
		
		return (order - mdFile.getOrder() == 0)? title.compareTo(mdFile.title) : order - mdFile.getOrder();
	}



	public MDFile(File file,int order,String title) {
		this.order = order;
		this.file = file;
		int idx = file.getPath().indexOf(title);
		this.title = file.getPath().substring(idx);
		int lastIndex = file.getName().lastIndexOf(".");
		ex = file.getName().substring(lastIndex + 1);
	}
}

```

---

### 24. MDFileGenerator.java

#### \src\main\java\com\suji\mdfilegen\model\MDFileGenerator.java

```java

package com.suji.mdfilegen.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.suji.mdfilegen.constants.Constants;

public class MDFileGenerator {

	public static File write(MDFileRepo repo) {

		File dest = new File(Constants.DESTINATION_PATH + "\\" + Constants.DESTINATION_FILE_NAME);
		PrintWriter out = null;
		FileReader fr = null;
		BufferedReader br = null;

		
		try {

			out = new PrintWriter(dest);

			// Writing Titles
			out.println("# " + Constants.APP_NAME);
			out.println(Constants.APP_DESC);
			out.println();
			
			// Index
			out.println("### Index");
			out.println("```pre");
			int index = 0;
			
			for(MDFile mdf : repo.getAllMdFiles()) {
				out.println((++index)+". " + mdf.getTitle());
			}
			out.println();
			out.println("```");
			out.println();
			out.println("---");
			out.println();
			// Printing Files
			index = 0;
			for (MDFile mdFile : repo.getAllMdFiles()) {

				fr = new FileReader(mdFile.getFile());

				br = new BufferedReader(fr);

				out.println("### " + (++index) + ". " + mdFile.getFile().getName());
				out.println();
				out.println("#### " + mdFile.getTitle());
				out.println();
				out.println("```" + mdFile.getEx());
				out.println();
				
				int i;
				while ((i = br.read()) != -1) {
					System.out.print((char) i);
					out.write((char) i);
				}
				out.println();
				out.println("```");
				out.println();
				out.println("---");
				out.println();
				
				out.flush();
			}

			System.out.println("Is File Found: " + dest.exists());

		} catch (IOException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				br.close();
				fr.close();
				out.close();
			} catch (IOException ex) {
				System.err.println(ex.getMessage());
			}
		}
		return dest;
	}

}

```

---

### 25. MDFileRepo.java

#### \src\main\java\com\suji\mdfilegen\model\MDFileRepo.java

```java

package com.suji.mdfilegen.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MDFileRepo {
	private List<MDFile> files = new ArrayList<>();
	
	public void addMD(MDFile md) {
		files.add(md);
	}
	
	public List<MDFile> getAllMdFiles(){
		return files;
	}
	
	public void addMD(File file, int order) {
		files.add(new MDFile(file, order));
	}
	
	public void addMD(File file, int order, String title) {
		files.add(new MDFile(file, order, title));
	}
	
	public void showAllMdFiles(){
		Collections.sort(files);
		files.forEach(System.out :: println);
	}
}

```

---

### 26. ApplicationTest.java

#### \src\test\java\com\suji\mdfilegen\ApplicationTest.java

```java


package com.suji.mdfilegen;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Application")
public class ApplicationTest {

  @Test
  @DisplayName("Pointless test")
  void smokeTest() {
    assertThat(true).isEqualTo(true);
  }
}

```

---


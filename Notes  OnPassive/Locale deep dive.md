A Locale object represents a specific geographical, political, or cultural region.

locale-sensitive: An operation that requires a Locale to perform its task.

Locale:
1. Country [a-zA-Z]{2} | [0-9]{3}	
2. Lang [a-zA-Z]{2,8}
3. Script Example: "Latn" (Latin), "Cyrl" (Cyrillic)

We can implement Internationalization by using the following three classes: 

Locale
NumberFormat
DateFormat
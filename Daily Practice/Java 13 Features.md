Java 13 Features


Preview Developer Features
Java 13 has brought in two new language features, albeit in the preview mode. This implies that these features are fully implemented for developers to evaluate, yet are not production-ready. Also, they can either be removed or made permanent in future releases based on feedback.


1. Switch Expressions with yield
 var result = switch (operation) {
        case "doubleMe" -> {
            yield me * 2;
        }
        case "squareMe" -> {
            yield me * me;
        }
        default -> me;
    };
	
	
2. Text Blocks

String TEXT_BLOCK_JSON = """
{
    "name" : "Baeldung",
    "website" : "https://www.%s.com/"
}
""";



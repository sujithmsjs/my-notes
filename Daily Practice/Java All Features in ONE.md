Stream methods added in 8, 9, 16

Records were introduced in Java 14. Java 16 brings some incremental changes.

Records:
- Immutable data holding object
- 


















Vocs

cumbersome	
incubate verb: hatch
cumbersome: nadjective

Swtich:

- Java supports multi-way comparisons with switch statements and, since Java 14, switch expressions (JEP 361), but unfortunately switch is very limited.
- Only works for: numerics, enum types, strings and constants.



// Java 16
static String formatterPatternSwitch(Object o) {
    return switch (o) {
        case Integer i -> String.format("int %d", i);
        case Long l    -> String.format("long %d", l);
        case Double d  -> String.format("double %f", d);
        case String s  -> String.format("String %s", s);
        default        -> o.toString();
    };
}

Pattern matching and null: 
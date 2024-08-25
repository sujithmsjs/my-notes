6. Serialization
----------------

9. Rules for serialization
--------------------------
- Must implements Serializable interface
- Subclasses automatically serializable themselves
- Only non-static fields are serialized by default
- It's recommended to explicitly define a serialVersionUID (serial version UID) as a static final long field in your serializable class.

10. How to exclude a field from serialization
---------------------------------------------
- You can mark it as transient to exclude it from serialization.
- Static fields and fields marked with transient are not included in the serialized data.

package org.es4j.serialization.api;

//import org.es4j.eventstore.api.dotnet.MemoryStream;

import org.es4j.dotnet.MemoryStream;
import org.es4j.dotnet.Stream;
import org.es4j.util.GenericType;

//import org.es4j.eventstore.api.dotnet.Stream;
//using System.IO;


/// Implements extension methods that make call to the serialization infrastructure more simple.
public class SerializationExtensions {

    /// Serializes the object provided.
    /// <typeparam name="T">The type of object to be serialized</typeparam>
    /// <param name="serializer">The serializer to use.</param>
    /// <param name="value">The object graph to be serialized.</param>
    /// <returns>A serialized representation of the object graph provided.</returns>
    public static <T> byte[] serialize(/*this*/ ISerialize serializer, T value) {

        try(Stream stream = new MemoryStream()) {
            serializer.serialize(stream, value);
            return stream.toArray();
        }
        catch(Exception ex) {
            throw new UnsupportedOperationException("Not yet implemented");
        }
    }

    /// Deserializes the array of bytes provided.
    /// <typeparam name="T">The type of object to be deserialized.</typeparam>
    /// <param name="serializer">The serializer to use.</param>
    /// <param name="serialized">The serialized array of bytes.</param>
    /// <returns>The reconstituted object, if any.</returns>
    public static <T> T deserialize(/*this*/ ISerialize serializer, GenericType<T> type, byte[] serialized) {
        return deserialize(serializer, type, serialized, null);
    }
    public static <T> T deserialize(/*this*/ ISerialize serializer, GenericType<T> type, byte[] serialized, T defaultValue) {

        if (serialized == null || serialized.length == 0) {
            return defaultValue; //return default(T); //return clazz.newInstance();
        }

        try (Stream stream = new MemoryStream(serialized)) {
            return serializer.deserialize(stream, type);
        }
        catch(Exception ex) {
            throw new UnsupportedOperationException("Not yet implemented");
        }
    }
}
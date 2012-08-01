package org.es4j.serialization.api;

import org.es4j.dotnet.Stream;
import org.es4j.util.GenericType;

//package org.es4j.eventstore.api.serialization;
//using System.IO;

/// Provides the ability to serialize and deserialize an object graph.
/// Instances of this class must be designed to be multi-thread safe such that they 
/// can be shared between threads.
public interface ISerialize {

    /// Serializes the object graph provided and writes a serialized representation 
    /// to the output stream provided.
    /// <typeparam name="T">The type of object to be serialized</typeparam>
    /// <param name="output">The stream into which the serialized object graph should be written.</param>
    /// <param name="graph">The object graph to be serialized.</param>
    <T> void serialize(Stream output, T graph);

    /// Deserializes the stream provided and reconstructs the corresponding object graph.
    /// 
    /// <typeparam name="T">The type of object to be deserialized.</typeparam>
    /// <param name="input">The stream of bytes from which the object will be reconstructed.</param>
    /// <returns>The reconstructed object.</returns>
    <T> T deserialize(Stream input, GenericType<T> type);
}
package org.es4j.serialization.api;

// Provides the ability to serialize an object graph to and from a document.

import org.es4j.util.GenericType;

// Instances of this class must be designed to be multi-thread safe such that they can be shared between threads.
public interface IDocumentSerializer {

    // Serializes the object graph provided into a document.
    // <typeparam name="T">The type of object to be serialized</typeparam>
    // <param name="graph">The object graph to be serialized.</param>
    // <returns>The document form of the graph provided.</returns>
    <T> Object serialize(T graph);

    // Deserializes the document provided into an object graph.
    // <typeparam name="T">The type of object graph.</typeparam>
    // <param name="document">The document to be deserialized.</param>
    // <returns>An object graph of the specified type.</returns>
    <T> T deserialize(Object document, GenericType<T> type);
}

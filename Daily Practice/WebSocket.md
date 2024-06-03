WebSocket

- WS is Bidirectional
- A full-duplex protocal(client-server communication)
- starts from ws:// or wss://. 
- It is a stateful protocol
- WebSocket is a thin, lightweight layer above TCP.
- STOMP is a subprotocol operating on top of the lower-level WebSocket.


# STOMP
# Streaming Text Oriented Messaging Protocol
STOMP, which stands for Simple (or Streaming) Text Oriented Messaging Protocol, is a lightweight and simple messaging protocol designed for use with messaging systems. It is particularly popular in the context of real-time communication and messaging over WebSocket connections. Here's an explanation of key aspects of STOMP:

Text-Based Protocol:
STOMP is a text-based protocol, which means that messages exchanged between clients and servers are human-readable strings. This simplicity makes it easy to implement and debug.
Message Frames:

STOMP messages are organized into frames, which are units of communication. A STOMP frame typically consists of a command, headers, an optional body, and an end-of-frame marker.
Commands include actions like CONNECT, SUBSCRIBE, UNSUBSCRIBE, SEND, BEGIN, COMMIT, and ABORT.
Header-Based Messaging:

STOMP messages include headers that provide additional metadata or information about the message. Headers can include details such as destination, content type, and message ID.















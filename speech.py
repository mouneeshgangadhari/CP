import websocket 
import pyaudio
import threading
import json

# WebSocket server URL
server_url = "ws://192.168.126.59:81/"

# PyAudio setup
FORMAT = pyaudio.paInt16
CHANNELS = 1
RATE = 44100
CHUNK = 1024

# Create PyAudio stream
p = pyaudio.PyAudio()
stream = p.open(format=FORMAT,
                channels=CHANNELS,
                rate=RATE,
                input=True,
                frames_per_buffer=CHUNK)

# WebSocket communication setup
ws = websocket.WebSocket()


def on_message(ws, message):
    print("Received message from server:", message)
    # You can process the text received from the server (if any)


def on_error(ws, error):
    print("WebSocket error:", error)


def on_close(ws, close_status_code, close_msg):
    print("WebSocket closed:", close_status_code, close_msg)


def on_open(ws):
    print("WebSocket connection opened")
    # Start a separate thread for recording and sending audio data
    threading.Thread(target=send_audio).start()


def send_audio():
    print("Recording and sending audio...")
    try:
        while True:
            # Read audio data from the microphone
            audio_data = stream.read(CHUNK, exception_on_overflow=False)
            # Send the audio data to the server
            ws.send(audio_data, websocket.ABNF.OPCODE_BINARY)
    except KeyboardInterrupt:
        print("Recording stopped.")
        ws.close()


if _name_ == "_main_":
    # Connect to the WebSocket server
    ws = websocket.WebSocketApp(server_url, on_message=on_message, on_error=on_error, on_close=on_close)
    ws.on_open = on_open
    ws.run_forever()
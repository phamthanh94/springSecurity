
function sendMessage() {
        var stompClient = null;
        var socket = new SockJS('/chat');
        stompClient = Stomp.over(socket);
        stompClient.connect({}, function(frame) {
            stompClient.subscribe('/topic/messages', function(message) {
                showMessageOutput(JSON.parse(message.body));
            });
        });
        var text = document.getElementById('btn-input').value;
        stompClient.send("/chat", {},
            JSON.stringify({'userName':'thanhpv', 'text':text}));
    }

function showMessageOutput(message) {
    var response = document.getElementById('response');
    var p = document.createElement('p');
    p.style.wordWrap = 'break-word';
    p.appendChild(document.createTextNode(message.userName + ": " + message.text));
    response.appendChild(p);
}


function ListNode(x) {
    this.val = x;
    this.next = null;
}

function printListFromTailToHead(head) {
    if (!head)
        return null;
    let array = [];
    while (head) {
        array.unshift(head.val);
        head = head.next;
    }
    return array;
}

function test() {
    let head;
    let h = new ListNode(0);
    head = h;
    for (let i = 1; i < 5; i++) {
        h.next = new ListNode(i);
        h = h.next;
    }
    console.log(printListFromTailToHead(head));
}

test();
function TreeNode(val) {
    this.val = val;
    this.left = this.right = null;
}

function Tree() {

    this.build = function (arr) {
        if (arr === null || arr.length === 0) return null;
        return buildTree(arr, 0);
    }

    function buildTree(arr, index) {
        if (index >= arr.length) return null;
        var root = new TreeNode(arr[index]);
        root.left = buildTree(arr, 2 * index + 1);
        root.right = buildTree(arr, 2 * index + 2);
        return root;
    }

    this.listDFS = function (root) {
        var arr = [];
        return listDFSTree(arr, root);
    }

    function listDFSTree(arr, root) {
        if (root !== null) {
            arr.push(root.val);
            arr.concat(listDFSTree(arr, root.left));
            arr.concat(listDFSTree(arr, root.right));
        }
        return arr;
    }

    this.listLevel = function (root) {
        if (root === null) return [];
        var queue = [];
        var arr = [];
        queue.push(root);
        while (queue.length > 0) {
            var node = queue.shift();
            arr.push(node.val);
            console.log(arr);
            node.left && queue.push(node.left);
            node.right && queue.push(node.right);
        }
        return arr;
    }

}

(function test() {
    var arr = [1, 2, 3, 4, 5, 6];
    var tree = new Tree();
    var root = tree.build(arr);
    console.log('level:',tree.listLevel(root));
    console.log('DFS:', tree.listDFS(root));
    console.log('path:',path(root, 7));
})();

function path(root, N) {
    if (root === null) return false;
    if (root.val === N) return true;
    return path(root.left, N - root.val) || path(root.right, N - root.val);
}


function TreeNode(val) {
    this.val = val;
    this.left = this.right = null;
}

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 * @param root
 * @returns {Array}
 */
var levelOrder = function (root) {
    if (root === null) return [];
    var queue = [];
    var results = [];
    queue.push(root);
    while (queue.length > 0) {
        var tmp = [];
        var length = queue.length;
        while (length--) {
            var node = queue.shift();
            tmp.push(node.val);
            node.left && queue.push(node.left);
            node.right && queue.push(node.right);
        }
        results.push(tmp);
    }
    return results;
};

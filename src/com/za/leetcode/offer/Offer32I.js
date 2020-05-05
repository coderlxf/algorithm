function TreeNode(val) {
    this.val = val;
    this.left = this.right = null;
}

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * @param root
 * @returns {Array}
 */
var levelOrder = function (root) {
    if (root === null) return [];
    var queue = [];
    var results = [];
    queue.push(root);
    while (queue.length > 0) {
        var node = queue.shift();
        results.push(node.val);
        node.left && queue.push(node.left);
        node.right && queue.push(node.right);
    }
    return results;
};

function TreeNode(val) {
    this.val = val;
    this.left = this.right = null;
}

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 * @param root
 * @returns {Array}
 */

var levelOrder = function (root) {
    if (root === null) return [];
    var queue = [];
    var results = [];
    queue.push(root);
    var level = 0;
    while (queue.length > 0) {
        results[level] = [];
        var length = queue.length;
        while (length--) {
            var node = queue.shift();
            results[level].push(node.val);
            node.left && queue.push(node.left);
            node.right && queue.push(node.right);
        }
        level % 2 && results[level].reverse();
        level++;
    }
    return results;
};

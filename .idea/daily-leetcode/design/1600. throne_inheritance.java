/**
 * https://leetcode.com/problems/throne-inheritance/description/
 *
 */
class ThroneInheritance {
    class Person {
        String name;
        List<Person> childrens;
        boolean isDead;

        Person(String name) {
            this.name = name;
            this.childrens = new ArrayList<>();
        }
    }

    Person root;

    public ThroneInheritance(String kingName) {
        root = new Person(kingName);
    }

    public void birth(String parentName, String childName) {
        dfsAddChild(root, parentName, childName);
    }

    public void death(String name) {
        dfsMarkDead(root, name);
    }

    public List<String> getInheritanceOrder() {
        List<String> inheritanceOrder = new ArrayList<>();
        dfsGetInheritanceOrder(root, inheritanceOrder);
        return inheritanceOrder;
    }

    private void dfsGetInheritanceOrder(Person root, List<String> inheritanceOrder) {
        if (!root.isDead) inheritanceOrder.add(root.name);

        List<Person> childs = root.childrens;
        for (int i=0;i<childs.size();i++) {
            dfsGetInheritanceOrder(childs.get(i), inheritanceOrder);
        }
    }

    private void dfsMarkDead(Person root, String name) {
        if (root.name.equals(name)) {
            root.isDead = true;
            return;
        }

        List<Person> childs = root.childrens;
        for (int i=0;i<childs.size();i++) {
            dfsMarkDead(childs.get(i), name);
        }
    }

    private void dfsAddChild(Person root, String parentName, String childName) {
        List<Person> childs = root.childrens;

        if (root.name.equals(parentName)) {
            childs.add(new Person(childName));
            return;
        }

        for (int i=0;i<childs.size();i++) {
            dfsAddChild(childs.get(i), parentName, childName);
        }
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */

/**
 * Optimize birth and death methods
 */
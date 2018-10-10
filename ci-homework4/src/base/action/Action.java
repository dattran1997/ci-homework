package base.action;

import base.GameObject;

public abstract class Action {
    // là class viết để thay thế cho hàm run của object
    // 3 action còn lại để quy định cho kiểu chạy của các hành động trong hàm run

    public boolean isDone;
    public abstract void run(GameObject master);
    public abstract void reset();
}

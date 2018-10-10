package base.physics;

import base.physics.BoxCollider;

public interface Physics {
    // physic chỉ mượn kiểu để tạo hàm chứ ko kế thưa hay .. gì Boxcollider cả
    public BoxCollider getBoxCollider();

}

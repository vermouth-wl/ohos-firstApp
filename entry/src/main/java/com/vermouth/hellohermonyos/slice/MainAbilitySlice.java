package com.vermouth.hellohermonyos.slice;

import com.vermouth.hellohermonyos.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;

import ohos.aafwk.content.Operation;
import ohos.agp.components.Button;
import ohos.agp.components.Component;

public class MainAbilitySlice extends AbilitySlice {

    //private DirectionalLayout myLayout = new DirectionalLayout(this);

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);

        // 加载xml布局
        super.setUIContent(ResourceTable.Layout_main_layout);
        // System.out.println("程序执行到了这一步");

        // 添加按钮事件
        // 从配置文件layout_main.xml中获取到id为nextButton的按钮
        Button button = (Button) findComponentById(ResourceTable.Id_nextButton);
        // System.out.println("程序已经执行到这一步了, 获取到了button的值为: " + button);

        if (button != null) {

            // 为按钮设置回调
            button.setClickedListener(new Component.ClickedListener() {
                @Override
                public void onClick(Component component) {
                    //System.out.println("按钮事件函数回调成功");
                    Intent secondIntent = new Intent();

                    // 指定待启动FA的bundleName和abilityName
                    Operation operation = new Intent.OperationBuilder()
                            .withDeviceId("")
                            .withBundleName("com.vermouth.hellohermonyos")
                            .withAbilityName("com.vermouth.hellohermonyos.SecondAbility")
                            .build();

                    secondIntent.setOperation(operation);

                    // 通过AbilitySlice的startAbility接口实现启动另一界面
                    startAbility(secondIntent);
                }
            });

        }
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}

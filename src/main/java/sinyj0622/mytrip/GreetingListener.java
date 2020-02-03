package sinyj0622.mytrip;

import java.util.Map;
import sinyj0622.mytrip.context.ApplicationContextListener;

public class GreetingListener implements ApplicationContextListener {

  @Override
  public void ContextInitialized(Map<String, Object> context) {
    System.out.println("[여행 관리 시스템]에 오신걸 환영합니다!");

  }

  @Override
  public void ContextDestroyed(Map<String, Object> context) {
    System.out.println("안녕히가세요!");

  }

}

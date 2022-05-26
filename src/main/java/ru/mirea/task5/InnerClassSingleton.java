package ru.mirea.task5;

public class InnerClassSingleton {
        private InnerClassSingleton() {}
        private static class LazyHolder {
            private static final InnerClassSingleton myClass = new InnerClassSingleton();
        }
        public synchronized static InnerClassSingleton getInstance() {
            return LazyHolder.myClass;
        }
}

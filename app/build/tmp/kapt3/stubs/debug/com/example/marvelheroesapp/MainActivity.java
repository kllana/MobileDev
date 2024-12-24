package com.example.marvelheroesapp;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\r\u001a\u00020\u000eH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\b\u0010\u0013\u001a\u00020\u000eH\u0002J\u0012\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u0016\u0010\u0017\u001a\u00020\u000e2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000bH\u0002J\b\u0010\u001a\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/example/marvelheroesapp/MainActivity;", "Landroidx/activity/ComponentActivity;", "()V", "database", "Lcom/example/marvelheroesapp/AppDatabase;", "hasError", "Landroidx/compose/runtime/MutableState;", "", "heroBD", "Lcom/example/marvelheroesapp/HeroDataBase;", "heroesState", "", "Lcom/example/marvelheroesapp/classes/HeroForRender;", "fetchHeroesAndUpdateDb", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateMD5Hash", "", "input", "handleFetchError", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "saveHeroesToDb", "heroes", "Lcom/example/marvelheroesapp/classes/Hero;", "updateHeroes", "app_debug"})
public final class MainActivity extends androidx.activity.ComponentActivity {
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.util.List<com.example.marvelheroesapp.classes.HeroForRender>> heroesState = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState<java.lang.Boolean> hasError = null;
    private com.example.marvelheroesapp.AppDatabase database;
    private com.example.marvelheroesapp.HeroDataBase heroBD;
    
    public MainActivity() {
        super(0);
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void updateHeroes() {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String generateMD5Hash(@org.jetbrains.annotations.NotNull
    java.lang.String input) {
        return null;
    }
    
    private final java.lang.Object fetchHeroesAndUpdateDb(kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final void saveHeroesToDb(java.util.List<com.example.marvelheroesapp.classes.Hero> heroes) {
    }
    
    private final void handleFetchError() {
    }
}
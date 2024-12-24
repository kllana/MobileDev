package com.example.marvelheroesapp;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0004J\u001b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/example/marvelheroesapp/HeroDataBase;", "", "deleteAllHeroes", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllHeroes", "", "Lcom/example/marvelheroesapp/EntityHero;", "getHeroById", "heroId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertHero", "hero", "(Lcom/example/marvelheroesapp/EntityHero;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertHeroes", "heroes", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao
public abstract interface HeroDataBase {
    
    @androidx.room.Query(value = "SELECT * FROM heroes")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAllHeroes(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.marvelheroesapp.EntityHero>> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM heroes WHERE id = :heroId LIMIT 1")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getHeroById(int heroId, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.marvelheroesapp.EntityHero> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertHeroes(@org.jetbrains.annotations.NotNull
    java.util.List<com.example.marvelheroesapp.EntityHero> heroes, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertHero(@org.jetbrains.annotations.NotNull
    com.example.marvelheroesapp.EntityHero hero, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM heroes")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteAllHeroes(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}
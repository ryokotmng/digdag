package io.digdag.core.repository;

import org.immutables.value.Value;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@ImmutableImplStyle
@JsonSerialize(as = ImmutableStoredScheduleSource.class)
public abstract class StoredScheduleSourceImpl
        extends StoredScheduleSource
{ }

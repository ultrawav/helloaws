package com.ultrawav.helloaws.specification;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.data.jpa.domain.Specification;

import com.ultrawav.helloaws.repository.entity.User;
import com.ultrawav.helloaws.repository.entity.User_;
import com.ultrawav.helloaws.repository.specification.UserSpecifications;

public class UserSpecificationsTest {

	private static final String SEARCH_TERM = "need4spd";
	private static final String SEARCH_TERM_LIKE_PATTERN = "need4spd%";
	
	private CriteriaBuilder criteriaBuilderMock;
	private CriteriaQuery<?> criteriaQueryMock;
	
	private Root<User> userRootMock;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setup() {
		criteriaBuilderMock = mock(CriteriaBuilder.class);
		criteriaQueryMock = mock(CriteriaQuery.class);
		userRootMock = mock(Root.class);
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void nameIsLike() {
		@SuppressWarnings("rawtypes")
		Path namePathMock = mock(Path.class);
		when(userRootMock.get(User_.name)).thenReturn(namePathMock);
		
		@SuppressWarnings("rawtypes")
		Expression nameToLowerExpressionMock = mock(Expression.class);
		when(criteriaBuilderMock.lower(namePathMock)).thenReturn(nameToLowerExpressionMock);
		
		Predicate nameIsLikePredicateMock = mock(Predicate.class);
		when(criteriaBuilderMock.like(nameToLowerExpressionMock, SEARCH_TERM_LIKE_PATTERN)).thenReturn(nameIsLikePredicateMock);
		
		Specification<User> actual = UserSpecifications.nameIsLike(SEARCH_TERM);
		Predicate actualPredicate = actual.toPredicate(userRootMock, criteriaQueryMock, criteriaBuilderMock);
		
		verify(userRootMock, times(1)).get(User_.name);
		verifyNoMoreInteractions(userRootMock);
		
		verify(criteriaBuilderMock, times(1)).lower(namePathMock);
		verify(criteriaBuilderMock, times(1)).like(nameToLowerExpressionMock, SEARCH_TERM_LIKE_PATTERN);
		verifyNoMoreInteractions(criteriaBuilderMock);
		
		verifyZeroInteractions(criteriaQueryMock, namePathMock, nameIsLikePredicateMock);
		
		Assert.assertEquals(nameIsLikePredicateMock, actualPredicate);
	}
}

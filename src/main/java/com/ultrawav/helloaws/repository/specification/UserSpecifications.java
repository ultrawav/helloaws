package com.ultrawav.helloaws.repository.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.ultrawav.helloaws.repository.entity.User;
import com.ultrawav.helloaws.repository.entity.User_;

public class UserSpecifications {

	public static Specification<User> nameIsLike(final String searchTerm) {
		if (null == searchTerm) {
			return null;
		}

		return new Specification<User>() {
			@Override
			public Predicate toPredicate(Root<User> userRoot,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				String likePattern = getLikePattern(searchTerm);
				return cb.like(cb.lower(userRoot.get(User_.name)),
						likePattern);
			}

			private String getLikePattern(final String searchTerm) {
				StringBuilder pattern = new StringBuilder();
				pattern.append(searchTerm.toLowerCase());
				pattern.append("%");
				return pattern.toString();
			}
		};
	}
}
